package io.github.xjrga.snack.database.callable;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.database.callable.insert.InsertFoodCategoryLinkTask;
import io.github.xjrga.snack.database.callable.insert.InsertFoodCategoryTask;
import io.github.xjrga.snack.database.callable.insert.InsertFoodFactTask;
import io.github.xjrga.snack.database.callable.insert.InsertFoodTask;
import io.github.xjrga.snack.database.callable.other.PrepareFoodDataTask;
import io.github.xjrga.snack.dataobject.Category;
import io.github.xjrga.snack.dataobject.Food;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.sql.Connection;
import java.util.Iterator;
import java.util.concurrent.Future;

public class FoodCreator {

	private final Food food;
	private final String foodid;
	private final String foodname;
	private final Iterator<Category> categoryIterator;
	private final Connection connection;

	public FoodCreator( Food food ) {

		this.food = food;
		foodid = food.getCheckSum();
		foodname = food.getFoodName();
		categoryIterator = food.getCategoryIterator();
		connection = Connect.getInstance().getConnection();

	}

	public boolean create() {

		Future<Boolean> task0;
		Future<Boolean> task1;
		Future<Boolean> task2;
		Future<Boolean> task3;
		Future<Boolean> task4;
		Boolean completed = false;
		Boolean task0Completed = false;
		Boolean task1Completed = false;
		Boolean task2Completed = false;
		Boolean task3Completed = false;
		Boolean task4Completed = false;

		try {

			task0 = BackgroundExec.submit( new InsertFoodTask( foodid, foodname ) );
			task0Completed = task0.get();

			if ( task0Completed ) {

				task1 = BackgroundExec.submit( new InsertFoodFactTask( food ) );
				task1Completed = task1.get();

			}

			String categoryid;

			while ( categoryIterator.hasNext() ) {

				Category next = categoryIterator.next();
				categoryid = next.getCategoryId();
				task2 = BackgroundExec.submit( new InsertFoodCategoryTask( categoryid, next.getCategoryName() ) );
				task2Completed = task2.get();
				task3 = BackgroundExec.submit( new InsertFoodCategoryLinkTask( categoryid, foodid ) );
				task3Completed = task3.get();

			}

			task4 = BackgroundExec.submit( new PrepareFoodDataTask( foodid ) );
			task4Completed = task4.get();
			completed = true;

		} catch (Exception e) {

			LoggerImpl.INSTANCE.logProblem( e );

		}

		return completed;

	}

}
