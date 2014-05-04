package com.DavideBasciano.tris;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Scelta extends Activity implements OnClickListener {

	Button b_m_off;
	Button b_m_on;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scelta);
		InitControls();
	}

	private void InitControls() {
		// TODO Auto-generated method stub
		b_m_off = (Button) this.findViewById(R.id.Offline);
		b_m_on = (Button) this.findViewById(R.id.Online);
		b_m_off.setOnClickListener(this);
		b_m_on.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==b_m_off.getId()) {
			Intent intent = new Intent(this, Multy.class);
			startActivity(intent);
		}
		else {
			Intent intent = new Intent(this, Multy_online.class);
			startActivity(intent);
		}
	}

}

