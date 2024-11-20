package com.teachmeskills.lesson_14.service;

import com.teachmeskills.lesson_14.exception.WrongDocException;
import com.teachmeskills.lesson_14.util.Constants;

import java.io.*;

public class CheckDoc {

    public static void validateDocs(String inputFilePath) throws WrongDocException {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                BufferedWriter docWriter = new BufferedWriter(new FileWriter(Constants.DOC_REPORT_VALID));
                BufferedWriter contractWriter = new BufferedWriter(new FileWriter(Constants.CONTRACT_REPORT_VALID));
                BufferedWriter invalidWriter = new BufferedWriter(new FileWriter(Constants.DOC_REPORT_INVALID))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                line = line.replace('с', 'c');
                try {
                    validateDocument(line);

                    if (line.startsWith(Constants.DOCNUM_NAME)) {
                        docWriter.write(line + "\n");
                        System.out.println("Valid DOCNUM: " + line);
                    } else if (line.startsWith(Constants.CONTRACT_NAME)) {
                        contractWriter.write(line + "\n");
                        System.out.println("Valid CONTRACT: " + line);
                    }
                } catch (WrongDocException e) {
                    String invalidEntry = line + " - " + e.getMessage();
                    invalidWriter.write(invalidEntry + "\n");
                    System.out.println("Invalid Document: " + invalidEntry);
                }
            }
            System.out.println("Validation completed");
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }

    private static void validateDocument(String docNumber) throws WrongDocException {
        if (docNumber.length() != Constants.DOCUM_LENGTH) {
            throw new WrongDocException("Invalid length");
        }
        if (!(docNumber.startsWith(Constants.DOCNUM_NAME) || docNumber.startsWith(Constants.CONTRACT_NAME))) {
            throw new WrongDocException("Invalid prefix");
        }
        if (!docNumber.matches("^[a-zA-Z0-9]+$")) {
            throw new WrongDocException("Invalid characters");
        }
    }
}
