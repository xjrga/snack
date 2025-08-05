package io.github.xjrga.snack.dataobject;

public class Category {

	private String categoryId;
	private String categoryName;

	public Category() {

		categoryId = "";
		categoryName = "";

	}

	public Category( String categoryId, String categoryName ) {

		this.categoryId = categoryId;
		this.categoryName = categoryName;

	}

	public String getCategoryId() {

		return categoryId;

	}

	public String getCategoryName() {

		return categoryName;

	}

	public void setCategoryId( String categoryId ) {

		this.categoryId = categoryId;

	}

	public void setCategoryName( String categoryName ) {

		this.categoryName = categoryName;

	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append( "Category{" );
		sb.append( "categoryId=" ).append( categoryId );
		sb.append( ", categoryName=" ).append( categoryName );
		sb.append( '}' );
		return sb.toString();

	}

}
