package fr.w3blog.zpl;

import fr.w3blog.zpl.constant.ZebraFont;
import fr.w3blog.zpl.model.ZebraPrintException;
import fr.w3blog.zpl.model.element.ZebraBarCode128;
import fr.w3blog.zpl.model.element.ZebraBarcodeEan13;
import fr.w3blog.zpl.model.element.ZebraText;
import fr.w3blog.zpl.utils.ZebraUtils;
import junit.framework.TestCase;
import fr.w3blog.zpl.model.ZebraLabel;

/**
 * Unit test for simple App.
 */
public class ZebraLabelTest
		extends TestCase
{

	/**
	 * Test with only label without element
	 */
	public void testZebraLabelAlone()
	{
		ZebraLabel zebraLabel = new ZebraLabel();
		assertEquals("^XA\n^MMT\n^XZ\n", zebraLabel.getZplCode());
	}

	/**
	 * Test with only label without element
	 */
	public void testZebraLabelSize()
	{
		ZebraLabel zebraLabel = new ZebraLabel(500, 760);
		assertEquals("^XA\n^MMT\n^PW500\n^LL760\n^XZ\n", zebraLabel.getZplCode());
	}

	public void testPrintLabelInCm() throws ZebraPrintException {
		ZebraLabel zebraLabel = new ZebraLabel(7.5f,3.7f);
		zebraLabel.setDefaultZebraFont(ZebraFont.ZEBRA_ZERO);
		//Add Code Bar 39
		zebraLabel.addElement(new ZebraBarcodeEan13(100, 297, "250000000538", 70, 2, 2));

		ZebraUtils.printZpl(zebraLabel, "192.168.200.6", 9100);
		System.out.println(zebraLabel.getZplCode());
		//assertEquals(true,"true");
	}

}
