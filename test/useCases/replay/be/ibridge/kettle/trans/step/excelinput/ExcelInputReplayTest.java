package be.ibridge.kettle.trans.step.excelinput;

import be.ibridge.kettle.core.Const;
import be.ibridge.kettle.trans.Trans;
import be.ibridge.kettle.trans.TransMeta;
import be.ibridge.kettle.trans.step.KettleStepUseCase;

public class ExcelInputReplayTest extends KettleStepUseCase {

	public void testInputOKIgnoreErrorsTrueStrictFalse() throws Exception {
		directory = "test/useCases/replay/excelInputReplayGoodIgnoreTrueStrictFalse/";
		expectFiles(directory, 2);
		meta = new TransMeta(directory + "transform.ktr");
		trans = new Trans(log, meta);
		boolean ok = trans.execute(null);
		assertTrue(ok);
		trans.waitUntilFinished();
		trans.endProcessing("end");
		assertEquals(0, trans.getErrors());
		expectFiles(directory, 2);
	}

	public void testInputOKIgnoreErrorsTrue() throws Exception {
		directory = "test/useCases/replay/excelInputReplayGoodIgnoreTrue/";
		expectFiles(directory, 2);
		meta = new TransMeta(directory + "transform.ktr");
		trans = new Trans(log, meta);
		boolean ok = trans.execute(null);
		assertTrue(ok);
		trans.waitUntilFinished();
		trans.endProcessing("end");
		assertEquals(0, trans.getErrors());
		expectFiles(directory, 2);
	}

	public void testInputOKIgnoreErrorsFalse() throws Exception {
		directory = "test/useCases/replay/excelInputReplayGoodIgnoreFalse/";
		expectFiles(directory, 2);
		meta = new TransMeta(directory + "transform.ktr");
		trans = new Trans(log, meta);
		boolean ok = trans.execute(null);
		assertTrue(ok);
		trans.waitUntilFinished();
		trans.endProcessing("end");
		assertEquals(0, trans.getErrors());
		expectFiles(directory, 2);
	}

	public void testInputErrorIgnoreErrorsFalse() throws Exception {
		directory = "test/useCases/replay/excelInputReplayErrorIgnoreFalse/";
		expectFiles(directory, 2);
		meta = new TransMeta(directory + "transform.ktr");
		trans = new Trans(log, meta);
		boolean ok = trans.execute(null);
		assertTrue(ok);
		trans.waitUntilFinished();
		trans.endProcessing("end");
		assertEquals(1, trans.getErrors());
		expectFiles(directory, 2);
	}

	public void testInputErrorIgnoreErrorsTrue() throws Exception {
		directory = "test/useCases/replay/excelInputReplayErrorIgnoreTrue/";
		expectFiles(directory, 2);
		meta = new TransMeta(directory + "transform.ktr");
		trans = new Trans(log, meta);
		boolean ok = trans.execute(null);
		assertTrue(ok);
		trans.waitUntilFinished();
		trans.endProcessing("end");
		assertEquals(0, trans.getErrors());
		expectFiles(directory, 6);
		expectContent(directory + "input.xls_Sheet1.line", "2" + Const.CR
				+ "19" + Const.CR);
		expectContent(directory + "input.xls_Sheet2.line", "10" + Const.CR
				+ "17" + Const.CR);
		expectContent(directory + "input.xls_Sheet1.dataerror",
				"text1-1\t1234.5\taiaia\t9876" + Const.CR
						+ "text1-18	9.87\t12/06/2005\tyoepie" + Const.CR);
		expectContent(directory + "input.xls_Sheet2.dataerror",
				"text2-9\t1234.5\tsome sing else\t9876" + Const.CR
						+ "text2-16\t9.87\t26/05/2005\tNOK" + Const.CR);
	}
	
	public void testInputErrorIgnoreErrorsTrueRowNrOnly() throws Exception {
		directory = "test/useCases/replay/excelInputReplayErrorIgnoreTrueRowNrOnly/";
		expectFiles(directory, 2);
		meta = new TransMeta(directory + "transform.ktr");
		trans = new Trans(log, meta);
		boolean ok = trans.execute(null);
		assertTrue(ok);
		trans.waitUntilFinished();
		trans.endProcessing("end");
		assertEquals(0, trans.getErrors());
		expectFiles(directory, 4);
		expectContent(directory + "input.xls_Sheet1.line", "2" + Const.CR
				+ "19" + Const.CR);
		expectContent(directory + "input.xls_Sheet2.line", "10" + Const.CR
				+ "17" + Const.CR);
	}
	
	public void testInputErrorIgnoreErrorsTrueDataErrorOnly() throws Exception {
		directory = "test/useCases/replay/excelInputReplayErrorIgnoreTrueDataErrorOnly/";
		expectFiles(directory, 2);
		meta = new TransMeta(directory + "transform.ktr");
		trans = new Trans(log, meta);
		boolean ok = trans.execute(null);
		assertTrue(ok);
		trans.waitUntilFinished();
		trans.endProcessing("end");
		assertEquals(0, trans.getErrors());
		expectFiles(directory, 4);
		expectContent(directory + "input.xls_Sheet1.dataerror",
				"text1-1\t1234.5\taiaia\t9876" + Const.CR
						+ "text1-18	9.87\t12/06/2005\tyoepie" + Const.CR);
		expectContent(directory + "input.xls_Sheet2.dataerror",
				"text2-9\t1234.5\tsome sing else\t9876" + Const.CR
						+ "text2-16\t9.87\t26/05/2005\tNOK" + Const.CR);
	}

	public String getFileExtension() {
		return "xls";
	}
}
