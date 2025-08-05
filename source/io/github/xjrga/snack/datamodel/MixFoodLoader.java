/*
 * Snack: Learning Software for Nutrition Copyright (C) 2018 Jorge R Garcia de Alba License:
 * http://www.gnu.org/licenses/gpl.html GPL version 2 or higher
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program; if
 * not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */
package io.github.xjrga.snack.datamodel;

import io.github.xjrga.snack.database.callable.BackgroundExec;
import io.github.xjrga.snack.database.callable.select.NamedMixFoodSortedByNameTask;
import io.github.xjrga.snack.dataobject.MixFoodDO;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class MixFoodLoader implements ReloadMixid {

	private ArrayList<MixFoodDO> food_list;

	public MixFoodLoader() {

	}

	public ArrayList<MixFoodDO> get() {

		return food_list;

	}

	@Override
	public void reload( String mixid ) {

		food_list = new ArrayList();

		try {

			Future<List<List>> task = BackgroundExec.submit( new NamedMixFoodSortedByNameTask( mixid ) );
			List<List> foods = task.get();
			foods.forEach( row -> {

				String foodid = ( String ) row.get( 0 );
				String name = ( String ) row.get( 1 );
				MixFoodDO foodDataObject = new MixFoodDO( foodid, name );
				food_list.add( foodDataObject );

			} );

		} catch (Exception e) {

			LoggerImpl.INSTANCE.logProblem( e );

		}

	}

}
