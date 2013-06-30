package com.app.sentinelsecurity;

import java.io.File;
import java.io.IOException;

import com.lowagie.text.DocumentException;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

public class FinalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_final);

		Button createPdf = (Button) findViewById(R.id.button_create);
		createPdf.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Document document = new Document();
				// try {
				//
				File file = new File(Environment.getExternalStorageDirectory() + File.separator + "droidText" + File.separator + "Test.pdf");
				//
				// PdfWriter.getInstance(document,
				// new FileOutputStream(file));
				//
				// // step 3: we open the document
				// document.open();
				// // step 4: we add a paragraph to the document
				// document.add(new Paragraph("Hello World"));
				// } catch (DocumentException de) {
				// System.err.println(de.getMessage());
				// } catch (IOException ioe) {
				// System.err.println(ioe.getMessage());
				// }
				//
				// // step 5: we close the document
				// document.close();
				
				try {
					new PdfBuilder().createPdf(file);
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
}
		});
	}

}
