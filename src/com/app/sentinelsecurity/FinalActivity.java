package com.app.sentinelsecurity;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.app.sentinelsecurity.domain.DbData;

public class FinalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_final);

		Button createPdf = (Button) findViewById(R.id.button_create);
		createPdf.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				File file = new File(Environment.getExternalStorageDirectory() + File.separator + "droidText"
						+ File.separator + "Test.pdf");
				try {
					DbData dbData = new DbData(FinalActivity.this);
					new PdfBuilder().createPdf(file, dbData.getQuestionsFromDB(1l));
					System.out.println("Pdf finished: " + file.getAbsolutePath());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("text/pdf");
				intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"jhamm.business@.com"});
				intent.putExtra(Intent.EXTRA_SUBJECT, "PDF file");
				intent.putExtra(Intent.EXTRA_TEXT, "Test");
				if (!file.exists() || !file.canRead()) {
				    finish();
				    return;
				}
				Uri uri = Uri.parse(file.getAbsolutePath());
				intent.putExtra(Intent.EXTRA_STREAM, uri);
				startActivity(Intent.createChooser(intent, "Send email..."));
			}
		});
	}

}
