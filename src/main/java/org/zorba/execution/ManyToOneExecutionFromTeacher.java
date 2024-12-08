package org.zorba.execution;

//import com.mysql.cj.result.Row;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.zorba.entity.Department;
import org.zorba.entity.Student;
import org.zorba.entity.Teacher;
import org.zorba.utility.DataBaseConnectivity;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;


public class ManyToOneExecutionFromTeacher {
    public static void main(String[] args) {

        SessionFactory sessionFactory = DataBaseConnectivity.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
//            Student student = new Student();
//            student.setStudentScore(89);
//            student.setStudentMobile(5412365L);
//            student.setStudentCourse("Eng00");
//            student.setStudentLocation("NYC");
//            student.setStudentName("Bibash");
//            student.setStudentEmail("bibash@gmail.com");
//            Teacher teacher = new Teacher();
//
//            teacher.setTeacherAddress("NYC");
//            teacher.setTeacherName("Abhishek");
//            teacher.setTeacherEmail("abhi@gmail.com");
//            teacher.setTeacherMobile(45212L);
//            teacher.setTeacherSpecialization("Science");
//            Set<Department> departmentSet = new HashSet<>();
//            Department department = new Department();
//            department.setDepartmentName("Science");
//            department.setDepartmentLocation("OH");
//            departmentSet.add(department);
//        department.setDepartmentName("Computer");
//        department.setDepartmentLocation("NYC");
//        departmentSet.add(department);
//            teacher.setDepartment(departmentSet);
//
//            student.setTeacher(teacher);

        try {
//                tx = session.beginTransaction();
//                session.persist(student);
//                tx.commit();
//                System.out.println("Student saved successfully");
////
            File file = new File("src/main/resources/education_systems.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(bufferedInputStream);
            //System.out.println("Number Of sheets : "+ xssfWorkbook.getNumberOfSheets());

            XSSFSheet studentSheet = xssfWorkbook.getSheetAt(1);
            //XSSFSheet teacherSheet = xssfWorkbook.getSheetAt(0);

            //Iterator<Row> rowIteratorTeacher = teacherSheet.iterator();
            // System.out.println("Total Number Of Rows : "+ sheet.getLastRowNum());
            //iterate over each row
            Iterator<Row> rowIteratorStudent = studentSheet.iterator();
            while (rowIteratorStudent.hasNext()) {
                Student student = new Student();
                Row row = rowIteratorStudent.next();
                // System.out.println("Row Number : "+row.getRowNum());
                //System.out.println("The number of Cell/Column : "+row.getLastCellNum() + 1);
                if (row.getRowNum() == 0) {
                    continue;
                }
                //Read the all the cell / column present in a particular row
                Iterator<Cell> cellIterator = row.cellIterator();
                //iterate over each cell of a row
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
                    //populating student object based on the column index
                    switch (cell.getColumnIndex()) {
                        case 0:
                            if (cell.getStringCellValue() == null) {
                                break;
                            }
                            //System.out.println("Name:: " + cell.getStringCellValue());
                            student.setStudentName(cell.getStringCellValue());
                            break;
                        case 1:
                            student.setStudentLocation("Location:: " + cell.getStringCellValue());
                            break;
                        case 2:
                            //System.out.println("Course:: " + cell.getStringCellValue());
                            student.setStudentCourse(cell.getStringCellValue());
                            break;
                        case 3:
                            //System.out.println("Email:: " + cell.getStringCellValue());
                            student.setStudentEmail(cell.getStringCellValue());
                            break;
                        case 4:
                           // System.out.println("Mobile:: " + cell.getNumericCellValue());
                            student.setStudentMobile((long) Float.parseFloat(String.valueOf(cell.getNumericCellValue())));
                            break;
                        case 5:
                            System.out.println("Teacher Name:: " + cell.getStringCellValue());
                            String teacherName = cell.getStringCellValue();
                            XSSFSheet teacherSheet = xssfWorkbook.getSheetAt(0);
                            Iterator<Row> rowIteratorTeacher = teacherSheet.iterator();
                            while (rowIteratorTeacher.hasNext()) {
                                Row rowTeacher = rowIteratorTeacher.next();
                                if (rowTeacher.getRowNum() == 0) {
                                    continue;
                                }
                                //Read the all the cell / column present in a particular row
                                Iterator<Cell> cellIteratorTeacher = rowTeacher.cellIterator();
                                //iterate over each cell of a row
                                while (cellIteratorTeacher.hasNext()) {
                                    Cell cellTeacher = cellIteratorTeacher.next();
                                    Teacher teacher = new Teacher();
                                    Cell nameColumn= row.getCell(0);
                                    String name= nameColumn.getStringCellValue();
                                    System.out.println("TeacherName:: " + name);
                                    if (name.equals(teacherName)) {
                                        switch (cellTeacher.getColumnIndex()) {
                                            case 0:
                                                teacher.setTeacherName(cellTeacher.getStringCellValue());
                                                break;
                                            case 1:
                                                Set<Department> departmentSet = new HashSet<Department>();
                                                XSSFSheet departmentSheet = xssfWorkbook.getSheetAt(2);
                                                Iterator<Row> rowIteratorDepartment = studentSheet.iterator();
                                                while (rowIteratorDepartment.hasNext()) {
                                                    Row rowDepartment = rowIteratorDepartment.next();
                                                    if (rowTeacher.getRowNum() == 0) {
                                                        continue;
                                                    }
                                                    Iterator<Cell> cellIteratorDepartment = rowDepartment.cellIterator();
                                                    while (cellIteratorTeacher.hasNext()) {
                                                        Cell cellDepartment = cellIteratorDepartment.next();
                                                        Department department = new Department();
                                                        switch (cellDepartment.getColumnIndex()) {
                                                            case 0:
                                                                department.setDepartmentName(cellDepartment.getStringCellValue());
                                                                break;
                                                            case 1:
                                                                department.setDepartmentLocation(cellDepartment.getStringCellValue());
                                                                break;
                                                        }
                                                        departmentSet.add(department);
                                                        session.persist(departmentSet);
                                                        System.out.println(departmentSet.toString());
                                                    }
                                                    break;
                                                }
                                                    case 2:
                                                        teacher.setTeacherEmail(cellTeacher.getStringCellValue());
                                                        break;
                                                    case 3:
                                                        teacher.setTeacherMobile((long) Float.parseFloat(String.valueOf(cell.getNumericCellValue())));
                                                        break;
                                                    case 4:
                                                        teacher.setTeacherAddress(cellTeacher.getStringCellValue());
                                                        break;

                                                }
                                                student.setTeacher(teacher);
                                        }else{
                                        continue;
                                    }


                                    }



                                }



                                break;
                                case 6:
                                    //System.out.println("Score:: " + cell.getNumericCellValue());
                                    student.setStudentScore((int) cell.getNumericCellValue());
                            }

                    }
                    tx = session.beginTransaction();
                    if (student.getStudentName() != null) {
                        session.persist(student);
                    }
                    //session.persist(student);
                    tx.commit();
                    //System.out.println("Student Saved Successfully...");
                    System.out.println();


                }
            } catch(FileNotFoundException e){
                throw new RuntimeException(e);
            } catch(IOException e){
                throw new RuntimeException(e);
            } finally{
                if (session != null) {
                    session.close();
                }
            }
        }
    }
