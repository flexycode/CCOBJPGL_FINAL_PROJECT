package com.artificialledgersrm.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Utility class for generating QR codes.
 */
public class QRCodeGenerator {
    /**
     * Generates a QR code as a byte array.
     *
     * @param text   The text to encode in the QR code
     * @param width  The width of the QR code image
     * @param height The height of the QR code image
     * @return A byte array representing the QR code image
     * @throws WriterException If there's an error writing the QR code
     * @throws IOException     If there's an error handling the byte stream
     */
    public static byte[] generateQRCode(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        return pngOutputStream.toByteArray();
    }
}
