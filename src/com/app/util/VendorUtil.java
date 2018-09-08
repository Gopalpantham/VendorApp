package com.app.util;

import java.io.File;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;


@Component
public class VendorUtil {
	public void generatePie(String path, List<Object[]> li) {
		// Convert list to Dataset
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Object[] ob : li) {
			dataset.setValue(ob[0].toString(),new Double(ob[1].toString()));
			// convert Dataset to Jfreechart
			JFreeChart chart = ChartFactory.createPieChart3D("VendorReports",dataset,true,true,false);
			// generate image using chart utils
			try {
				ChartUtilities.saveChartAsJPEG(new File(path + "/VenPieA.jpg"),chart,250,250);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void generateBarcharts(String path, List<Object[]> li) {
		// create DataSet
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (Object[] ob : li) {
			dataset.setValue(new Double(ob[1].toString()), ob[0].toString(),"");
			// convert Dataset to jfreechar
		}
		JFreeChart chart = ChartFactory.createBarChart3D("VendorReports","VendorType", "count", dataset);
		try {
			ChartUtilities.saveChartAsJPEG(new File(path + "/VenBarB.jpg"),chart,250,250);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
