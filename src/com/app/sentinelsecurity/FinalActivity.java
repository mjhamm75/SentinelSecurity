package com.app.sentinelsecurity;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
//				File inputFile = new File(Environment.getExternalStorageDirectory() + File.separator + "droidText"
//						+ File.separator + "Test.pdf");
				
				File inputFile = new File(Environment.getExternalStorageDirectory() + "/Test.pdf");
				try {
					DbData dbData = new DbData(FinalActivity.this);
					new PdfBuilder().createPdf(inputFile, dbData.getQuestionsFromDB(1l));
					System.out.println("Pdf finished: " + inputFile.getAbsolutePath());
				} catch (Exception e) {
					e.printStackTrace();
				}

				FileInputStream isr = null;
				try {
					isr = new FileInputStream(inputFile);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				DataInputStream in = new DataInputStream(isr);

				// Intent intent = new Intent(Intent.ACTION_SEND);
				// intent.setType("text/pdf");
				// intent.putExtra(Intent.EXTRA_EMAIL, new String[] {
				// "jhamm.business@gmail.com" });
				// intent.putExtra(Intent.EXTRA_SUBJECT, "PDF file");
				// intent.putExtra(Intent.EXTRA_TEXT, "Test");
				// if (!inputFile.exists() || !inputFile.canRead()) {
				// finish();
				// return;
				// }
				// Uri uri = Uri.parse(inputFile.getAbsolutePath());
				// intent.putExtra(Intent.EXTRA_STREAM, uri);
				// startActivity(Intent.createChooser(intent, "Send email..."));

				if (inputFile.exists()) {
					Uri path = Uri.fromFile(inputFile);
					Intent intent = new Intent(Intent.ACTION_VIEW);
					intent.setDataAndType(path, "application/pdf");
					intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

					try {
						startActivity(intent);
					} catch (ActivityNotFoundException e) {
						e.printStackTrace();
						Toast.makeText(FinalActivity.this, "No Application Available to View PDF", Toast.LENGTH_SHORT)
								.show();
					}
				}
			}
		});

	}

	private void loadDocInReader(String doc) throws ActivityNotFoundException, Exception {

		try {
			Intent intent = new Intent();

			intent.setPackage("com.adobe.reader");
			intent.setDataAndType(Uri.parse(doc), "application/pdf");

			startActivity(intent);

		} catch (ActivityNotFoundException activityNotFoundException) {
			activityNotFoundException.printStackTrace();

			throw activityNotFoundException;
		} catch (Exception otherException) {
			otherException.printStackTrace();

			throw otherException;
		}
	}

}
