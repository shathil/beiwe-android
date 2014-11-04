package org.beiwe.app.ui;

import org.beiwe.app.LoadingActivity;
import org.beiwe.app.R;
import org.beiwe.app.session.LoginManager;
import org.beiwe.app.survey.AudioRecorderActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
/**The main menu activity of the app. Currently displays 4 buttons - Audio Recording, Graph, Hotline, and Sign out.
 * @author Dor Samet, Eli Jones */
public class MainMenuActivity extends Activity {
	//extends a SessionActivity
	private Context appContext;	 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		appContext = getApplicationContext();
	}
	
	/**Calls... the hotline. */
	public void callHotline(View v) {
		Intent callIntent = new Intent(Intent.ACTION_CALL);
		String phoneNum = (String) getApplicationContext().getResources().getText(R.string.hotline_phone_number);
	    callIntent.setData(Uri.parse("tel:" + phoneNum));
	    startActivity(callIntent);
	}

	/*#########################################################################
	############################## Buttons ####################################
	#########################################################################*/
	
	public void signOutButton(View v) {
		LoginManager.setLoggedIn(false);
		startActivity( new Intent(appContext, LoadingActivity.class) );
	}
	
	public void graphResults (View v) { startActivity( new Intent(appContext, GraphActivity.class) ); }
	public void recordMessage(View v) { startActivity( new Intent(appContext, AudioRecorderActivity.class) );	}
	public void resetPassword(View v) { startActivity( new Intent(appContext, ResetPasswordActivity.class) ); }
}
