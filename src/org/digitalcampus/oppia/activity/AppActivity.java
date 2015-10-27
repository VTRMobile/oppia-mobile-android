/* 
 * This file is part of OppiaMobile - https://digital-campus.org/
 * 
 * OppiaMobile is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * OppiaMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with OppiaMobile. If not, see <http://www.gnu.org/licenses/>.
 */

package org.digitalcampus.oppia.activity;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.Date;

import org.digitalcampus.mobile.learning.R;
import org.digitalcampus.oppia.application.ScheduleReminders;


public class AppActivity extends FragmentActivity {
	
	public static final String TAG = AppActivity.class.getSimpleName();
	
	private ScheduleReminders reminders;
	private long lastActivity;
	
	/**
	 * @param activities
	 */
	public void drawReminders(ArrayList<org.digitalcampus.oppia.model.Activity> activities){
		try {
			reminders = (ScheduleReminders) findViewById(R.id.schedule_reminders);
			reminders.initSheduleReminders(activities);
		} catch (NullPointerException npe) {
			// do nothing
		}
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
			case android.R.id.home:
				this.finish();
				return true;
		}
		return true;
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
	    lastActivity = new Date().getTime();
	    return super.dispatchTouchEvent(ev);
	}
	
	@Override
	public void onResume() {
		super.onResume();
	    long now = new Date().getTime();
	    if (now - lastActivity > 5000) {
	    	Log.d(TAG, String.valueOf(now));
	    	Log.d(TAG, String.valueOf(lastActivity));
	       Log.d(TAG, "would be logging out now....");
	    }
	} 

}
