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
public class LocationUtil {
	public void generatePie(String path, List<Object[]> List) {
		// Convert list to Dataset
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Object[] ob : List) {
			dataset.setValue(ob[0].toString(),new Double(ob[1].toString()));
			// convert Dataset to Jfreechart
			JFreeChart chart = ChartFactory.createPieChart3D("LocationReports",dataset,true,true,false);
			// generate image using chart utils
			try {
				ChartUtilities.saveChartAsJPEG(new File(path + "/LocPieA.jpg"),chart,250,250);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void generateBarcharts(String path, List<Object[]> List) {
		// create DataSet
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (Object[] ob : List) {
			dataset.setValue(new Double(ob[1].toString()), ob[0].toString(),"");
			// convert Dataset to jfreechar
		}
		JFreeChart chart = ChartFactory.createBarChart3D("LocationReports","LocationType", "count", dataset);
		try {
			ChartUtilities.saveChartAsJPEG(new File(path + "/LocBarB.jpg"),chart,250,250);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
