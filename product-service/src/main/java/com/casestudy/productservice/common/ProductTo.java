package com.casestudy.productservice.common;

public class ProductTo {
	


		
		private int productId;

		private String productName;
		
		private  String productCategory;
		
		private String  productType;
		
		private String  productDescription;
		
		private double price;
		

		private int rating;
		
		private String reviews;
		public ProductTo()
		{
			
		}

		public ProductTo(int productId, String productName, String productCategory, String productType,
				String productDescription, double price, int rating, String reviews) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.productCategory = productCategory;
			this.productType = productType;
			this.productDescription = productDescription;
			this.price = price;
			this.rating = rating;
			this.reviews = reviews;
		}

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getProductCategory() {
			return productCategory;
		}

		public void setProductCategory(String productCategory) {
			this.productCategory = productCategory;
		}

		public String getProductType() {
			return productType;
		}

		public void setProductType(String productType) {
			this.productType = productType;
		}

		public String getProductDescription() {
			return productDescription;
		}

		public void setProductDescription(String productDescription) {
			this.productDescription = productDescription;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

		public String getReviews() {
			return reviews;
		}

		public void setReviews(String reviews) {
			this.reviews = reviews;
		}
		
		
}
