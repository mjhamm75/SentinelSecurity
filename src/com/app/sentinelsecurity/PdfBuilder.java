package com.app.sentinelsecurity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.GrayColor;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfFormField;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPCellEvent;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.RadioCheckField;

public class PdfBuilder {
	private Document document = null;
	public final int FIELD_TYPE_TEXTAREA = 1;
	public final int FIELD_TYPE_RADIO = 2;
	public final int FIELD_TYPE_CHECKBOX = 3;

	public static final Font BOLD_UNDERLINED = new Font(Font.TIMES_ROMAN, 12, Font.BOLD | Font.UNDERLINE);
	public static final Font BOLD = new Font(Font.TIMES_ROMAN, 12, Font.BOLD);
	public static final Font BOLD_SMALL = new Font(Font.TIMES_ROMAN, 10, Font.BOLD);
	public static final Font UNDERLINED = new Font(Font.TIMES_ROMAN, 12, Font.UNDERLINE);
	public static final Font NORMAL = new Font(Font.TIMES_ROMAN, 10);
	public static final Font NORMAL_BOLD = new Font(Font.TIMES_ROMAN, 10, Font.BOLD);
	public static final Font NORMAL_SMALL = new Font(Font.TIMES_ROMAN, 8);

	/** Path to the resulting PDF file. */

	public void createPdf(File file) throws DocumentException, IOException {
		CreatePdf(file);
	}

	public void CreatePdf(File file) throws DocumentException, IOException {
		// step 1
		document = new Document();
		// step 2
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		addCompanyLogo(document);

		addReportHeader(document, writer);
		addNotficationSection(document, writer);
		addSystemTestSection(document, writer);
		addSupervisorySection(document, writer);
		addMonitoringSection(document, writer);
		addNotficationSection(document, writer);
		addGeneralComments(document, writer);
		addReportFooter(document, writer);
		document.close();
	}

	public void addCompanyLogo(Document document) throws DocumentException {
		Paragraph preface = new Paragraph();
		// We add one empty line
		addEmptyLine(preface, 1);
		document.add(preface);
	}

	public void addReportHeader(Document document, PdfWriter writer) throws DocumentException {
		Chunk mediumSpace = new Chunk("               ");
		mediumSpace.setFont(NORMAL_SMALL);

		Phrase firstLine = new Phrase();
		firstLine.add(new Chunk("PROPERTY NAME:", BOLD));
		firstLine.add(getSmallSpace());
		firstLine.add(new Chunk("                                                             ", UNDERLINED));
		firstLine.add(mediumSpace);
		firstLine.add(new Chunk("DATE:", BOLD));
		firstLine.add(getSmallSpace());
		firstLine.add(new Chunk("                                                   ", UNDERLINED));

		document.add(firstLine);
		document.add(Chunk.NEWLINE);

		Phrase secondLine = new Phrase();
		secondLine.add(new Chunk("ADDRESS:", BOLD));
		secondLine.add(getSmallSpace());
		secondLine.add(new Chunk("                                                                              ",
				UNDERLINED));
		secondLine.add(mediumSpace);
		secondLine.add(new Chunk("TELEPHONE:", BOLD));
		secondLine.add(getSmallSpace());
		secondLine.add(new Chunk("                                     ", UNDERLINED));

		document.add(secondLine);
		document.add(Chunk.NEWLINE);

		Phrase thirdLine = new Phrase();
		thirdLine.add(new Chunk("CONTACT PERSON:", BOLD));
		thirdLine.add(getSmallSpace());
		thirdLine.add(new Chunk("                                                           ", UNDERLINED));
		thirdLine.add(mediumSpace);
		thirdLine.add(new Chunk("ACCOUNT:", BOLD));
		thirdLine.add(getSmallSpace());
		thirdLine.add(new Chunk("                                          ", UNDERLINED));

		document.add(thirdLine);
		document.add(Chunk.NEWLINE);

		Chunk inspectionService = new Chunk("Inspection Service:", NORMAL_BOLD);
		document.add(inspectionService);

		document.add(Chunk.NEWLINE);

		Phrase fourthLine = new Phrase();
		fourthLine.add(new Chunk("Panel Manufacturer:", NORMAL_BOLD));
		fourthLine.add(getSmallSpace());
		fourthLine.add(new Chunk("                                                      ", UNDERLINED));
		fourthLine.add(mediumSpace);
		fourthLine.add(new Chunk("Model Number:", NORMAL_BOLD));
		fourthLine.add(getSmallSpace());
		fourthLine.add(new Chunk("                                                     ", UNDERLINED));
		document.add(fourthLine);
		document.add(Chunk.NEWLINE);

		Phrase fifthLine = new Phrase();
		fifthLine.add(new Chunk("Number and Size of Lead Acid Batteries:", NORMAL_BOLD));
		fifthLine.add(getSmallSpace());
		fifthLine
				.add(new Chunk(
						"                                                                                                                 ",
						UNDERLINED));
		document.add(fifthLine);
	}

	public void addNotficationSection(Document document, PdfWriter writer) throws DocumentException {
		String[] rows = { "Building Occupants", "Building Maintainence", "Central Station(s)" };
		String[] columns = { "", "YES", "NO", "WHO", "TIME" };
		createFiveColumnChecklist(columns, rows, writer);
	}

	public void addSystemTestSection(Document document, PdfWriter writer) throws DocumentException {
		String[] rows = { "Control Panel", "Interface Equipment", "Lamps/LEDS/Fuses", "Primary Power Supply",
				"Trouble Signals", "Disconnect Switch", "Grnd. Fault Monitoring", "Battery Condition", "Load Voltage",
				"Discharge Test", "Charger Test", "Remote Annunciators", "Notification Appliances",
				"Speakers/Voice Clarity" };
		String[] columns = { "TYPE", "VISUAL", "FUNCTIONAL", "COMMENTS" };
		createFourColumnChecklist(columns, rows, writer);
	}

	private void addSupervisorySection(Document document, PdfWriter writer) throws DocumentException {
		String[] rows = { "Smoke Detectors", "Pull Stations", "Waterflows", "Tampers", "Duct Detectors",
				"Heat Detectors", "Others" };
		String[] columns = { "TYPE", "VISUAL", "FUNCTIONAL", "LOCATION/COMMENT" };
		createFourColumnChecklist(columns, rows, writer);
	}

	private void addMonitoringSection(Document document, PdfWriter writer) throws DocumentException {
		String[] rows = { "Alarm Signals/Restore", "Trouble Signal/Restore", "Supervisory" };
		String[] columns = { "", "YES", "NO", "TIME", "COMMENTS" };
		createFiveColumnChecklist(columns, rows, writer);
	}

	private void addGeneralComments(Document document, PdfWriter writer) throws DocumentException {
		Chunk generalComments = new Chunk("General Comments:");
		Chunk underline = new Chunk(
				"                                                                                                                                        ",
				UNDERLINED);
		Chunk underline2 = new Chunk(
				"                                                                                                                                                                                ",
				UNDERLINED);
		document.add(generalComments);
		document.add(getSmallSpace());
		document.add(underline);
		document.add(underline2);
		document.add(underline2);
		document.add(underline2);
		document.add(underline2);

	}

	private void addReportFooter(Document document, PdfWriter writer) throws DocumentException {
		Chunk technician = new Chunk("SERVICED BY:", BOLD);
		Chunk serviceDate = new Chunk("DATE:", BOLD);
		Chunk serviceTime = new Chunk("TIME:", BOLD);
		document.add(technician);
		document.add(getSmallSpace());
		document.add(new Chunk("                                                        ", UNDERLINED));
		document.add(getSmallSpace());
		document.add(serviceDate);
		document.add(getSmallSpace());
		document.add(new Chunk("                            ", UNDERLINED));
		document.add(getSmallSpace());
		document.add(serviceTime);
		document.add(getSmallSpace());
		document.add(new Chunk("                            ", UNDERLINED));
	}

	private Chunk getSmallSpace() {
		Chunk smallSpace = new Chunk("  ");
		smallSpace.setFont(NORMAL_SMALL);
		return smallSpace;
	}

	private PdfPTable createFourColumnChecklist(String[] columns, String[] rows, PdfWriter writer)
			throws DocumentException {
		PdfPTable table = createTable(new float[] { 2f, 1f, 1f, 4f }, 100f);
		createTableHeaders(columns, table);
		createFourColumnBody(rows, table, writer);
		return table;
	}

	private void createFourColumnBody(String[] rowLabels, PdfPTable table, PdfWriter writer) throws DocumentException {
		PdfFormField checkboxGroupField = PdfFormField.createCheckBox(writer);
		for (String label : rowLabels) {
			PdfPCell cell = table.getDefaultCell();
			cell = new PdfPCell(new Paragraph(label));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

			cell = new PdfPCell(table.getDefaultCell());
			cell.setCellEvent(new CellField(writer, checkboxGroupField, true));
			table.addCell(cell);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph("                    "));
			table.addCell(cell);
		}

		document.add(table);
		writer.addAnnotation(checkboxGroupField);

	}

	private PdfPTable createFiveColumnChecklist(String[] columns, String[] rows, PdfWriter writer)
			throws DocumentException {
		PdfPTable table = createTable(new float[] { 2f, 1f, 1f, 2.5f, 1.5f }, 100f);

		createTableHeaders(columns, table);
		createFiveColumnBody(rows, table, writer);
		return table;
	}

	private PdfPTable createTable(float[] columnWidths, float percentageSize) throws DocumentException {
		PdfPTable table = new PdfPTable(columnWidths.length);
		table.setWidthPercentage(percentageSize);
		table.setWidths(columnWidths);
		return table;
	}

	private void createFiveColumnBody(String[] rowLabels, PdfPTable table, PdfWriter writer) throws DocumentException {
		PdfFormField checkboxGroupField = PdfFormField.createCheckBox(writer);
		PdfPCell cell = null;
		for (String label : rowLabels) {
			cell = new PdfPCell(new Paragraph(label));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

			cell = new PdfPCell(table.getDefaultCell());
			cell.setCellEvent(new CellField(writer, checkboxGroupField, true));
			table.addCell(cell);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph("                    "));
			table.addCell(cell);
			cell = new PdfPCell(new Paragraph("                     "));
			table.addCell(cell);
		}
		document.add(table);
		writer.addAnnotation(checkboxGroupField);
	}

	private void createTableHeaders(String[] columns, PdfPTable table) {
		PdfPCell cell = null;
		for (String column : columns) {
			cell = new PdfPCell(new Paragraph(column));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
		}
	}

	private Document getDocument() {
		if (document != null)
			return document;
		else
			return new Document();
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	protected class CellField implements PdfPCellEvent {
		private PdfFormField parent;

		private String partialFieldName;
		private PdfWriter writer;
		private boolean checked;

		public CellField(PdfWriter writer, PdfFormField parent, boolean checked) {
			this.writer = writer;
			this.parent = parent;
			this.checked = checked;
		}

		public void cellLayout(PdfPCell cell, Rectangle rect, PdfContentByte[] cb) {
			try {
				createCheckboxField(rect);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

		}

		private void createCheckboxField(Rectangle rect) throws IOException, DocumentException {
			RadioCheckField rf = new RadioCheckField(writer, new Rectangle(rect.getLeft(2), rect.getBottom(2),
					rect.getRight(2), rect.getTop(2)), partialFieldName, "");
			rf.setChecked(checked);
			rf.setBorderColor(GrayColor.GRAYBLACK);
			rf.setBackgroundColor(GrayColor.GRAYWHITE);
			rf.setCheckType(RadioCheckField.TYPE_CHECK);
			parent.addKid(rf.getCheckField());
		}
	}
}
