package com.orgabor.sportsgearstore.utils;

import com.orgabor.sportsgearstore.products.Categories;

public class ImgPathBuilder {
	private final static String imgSourceFolder = "../../images/";
	
	public static String buildImgPath(Categories category, String imgName) {
		return imgSourceFolder + category.name().toLowerCase() + "/" + imgName;
	}
}
