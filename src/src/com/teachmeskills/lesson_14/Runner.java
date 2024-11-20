package com.teachmeskills.lesson_14;


/*Допустим есть файл с номерами документов.
Номером документа является строка, состоящая из букв и цифр(без служебных символов).
Пусть этот файл содержит каждый номер документа с новой строки и в строке никакой другой информации,
только номер документа.
Валидный номер документа должен иметь длину 15 символов и начинаться с последовательности docnum
(далее любая последовательность букв/цифр) или сontract(далее любая последовательность букв/цифр).
Написать программу для чтения информации из входного файла -
путь к входному файлу должне задаваться через консоль.
Программа должна проверять номера документов на валидность.
Валидные номера документов docnum следует записать в один файл-отчет.
Валидные номера контрактов сontract следует записать в другой файл-отчет.
Невалидные номера документов следует записать в другой файл-отчет,
но после номеров документов следует добавить ифнформацию о том, почему этот документ невалиден
(неправильная последовательность символов в начале/есть служебные символы в имени документа и другое).*/

import com.teachmeskills.lesson_14.exception.WrongDocException;
import com.teachmeskills.lesson_14.service.CheckDoc;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws WrongDocException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the input file:");
        // D:\Java\TMS_C32_Lesson_14\out\resources\document\file_doc.txt
        String inputFile = scanner.nextLine();

        CheckDoc.validateDocs(inputFile);
    }
}
