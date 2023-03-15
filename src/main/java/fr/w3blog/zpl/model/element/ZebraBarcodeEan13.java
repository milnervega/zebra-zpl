package fr.w3blog.zpl.model.element;

import fr.w3blog.zpl.model.PrinterOptions;
import fr.w3blog.zpl.utils.ZplUtils;

public class ZebraBarcodeEan13 extends ZebraBarCode<ZebraBarcodeEan13>{

    private boolean checkDigit43 = false;

    @Override
    protected ZebraBarcodeEan13 getThis() {
        return this;
    }

    @Override
    public String getZplCode(PrinterOptions printerOptions) {
        StringBuilder zpl = getStartZplCodeBuilder();
        zpl.append(ZplUtils.zplCommandSautLigne("BE", zebraRotation.getLetter(), barCodeHeigth, checkDigit43, showTextInterpretation, showTextInterpretationAbove));
        zpl.append("^FD");
        zpl.append(text);
        zpl.append(ZplUtils.zplCommandSautLigne("FS"));
        return zpl.toString();
    }
    public ZebraBarcodeEan13(int positionX, int positionY, String text) {
        super(positionX, positionY, text);
    }

    public ZebraBarcodeEan13(int positionX, int positionY, String text, int barCodeHeigth) {
        super(positionX, positionY, text, barCodeHeigth);
    }

    public ZebraBarcodeEan13(int positionX, int positionY, String text, int barCodeHeigth, int moduleWidth, int wideBarRatio) {
        super(positionX, positionY, text, barCodeHeigth, moduleWidth, wideBarRatio);
    }

    public ZebraBarcodeEan13(int positionX, int positionY, String text, int barCodeHeigth, boolean showTextInterpretation, int moduleWidth, int wideBarRatio) {
        super(positionX, positionY, text, barCodeHeigth, showTextInterpretation, moduleWidth, wideBarRatio);
    }

    public ZebraBarcodeEan13(int positionX, int positionY, String text, int barCodeHeigth, boolean showTextInterpretation, boolean showTextInterpretationAbove) {
        super(positionX, positionY, text, barCodeHeigth, showTextInterpretation, showTextInterpretationAbove);
    }

    public boolean isCheckDigit43() {
        return checkDigit43;
    }

    public ZebraBarcodeEan13 setCheckDigit43(boolean checkDigit43) {
        this.checkDigit43 = checkDigit43;
        return this;
    }
}
