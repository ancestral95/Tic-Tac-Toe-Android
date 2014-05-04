package com.DavideBasciano.tris;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Tris extends Activity implements OnClickListener {

	Button b_s;
	Button b_m;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selezione);
		InitControls();
	}

	private void InitControls() {
		// TODO Auto-generated method stub
		b_s = (Button) this.findViewById(R.id.Singolo);
		b_m = (Button) this.findViewById(R.id.Multiplayer);
		b_s.setOnClickListener(this);
		b_m.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==b_s.getId()) {
			Intent intent = new Intent(this, Singolo.class);
			startActivity(intent);
		}
		else {
			Intent intent = new Intent(this, Scelta.class);
			startActivity(intent);
		}
	}

}
