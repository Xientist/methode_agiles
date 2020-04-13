package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.sql.Date;
import java.time.LocalDate;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author e1802484
 */
public class TransactionDAO {

    final static String URL = "jdbc:mysql://localhost:3306/budget_managment?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    final static String LOGIN = "root";
    final static String PASS = "";

    public TransactionDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e2) {
            System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
        }

    }

    public int insert(Transaction transaction) {
        Connection con = null;
        PreparedStatement ps = null;
        int retour = 0;

        //connexion ﾃ� la base de donnﾃｩes
        try {

            //tentative de connexion
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            //prﾃｩparation de l'instruction SQL, chaque ? reprﾃｩsente une valeur ﾃ� communiquer dans l'insertion
            //les getters permettent de rﾃｩcupﾃｩrer les valeurs des attributs souhaitﾃｩs de nouvArticle
            ps = con.prepareStatement("INSERT INTO transaction (ID,Monatnt, Categorie, Date_T, Personne) VALUES (0, ?, ?, ?,?)");
            ps.setDouble(1, transaction.getMontant());
            ps.setString(2, transaction.getCategorie());
            ps.setDate(3, transaction.getDate_T());
            ps.setInt(4, transaction.getPersonne());

            //Exﾃｩcution de la requﾃｪte
            retour = ps.executeUpdate();

        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            //fermeture du preparedStatement et de la connexion
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception t) {
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception t) {
            }
        }
        return retour;

    }

    public void Delete(int id) {
        Connection con = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        int retour = 0;

        //connexion ﾃ� la base de donnﾃｩes
        try {
            //tentative de connexion
            con = DriverManager.getConnection(URL, LOGIN, PASS);

            //verifier si la transaction exist 
            ps2 = con.prepareStatement("SELECT * FROM transaction WHERE ID=?");
            ps2.setInt(1, id);
            //Exﾃｩcution de la requﾃｪte
            rs = ps2.executeQuery();
            if (rs.next()) {
                ps1 = con.prepareStatement("DELETE FROM transaction WHERE ID=?");
                ps1.setInt(1, id);
                //Exﾃｩcution de la requﾃｪte
                ps1.executeUpdate();

                System.out.println("well deleted");
            } else {
                System.out.println("transaction not found");
            }

        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            //fermeture du preparedStatement et de la connexion
            try {
                if (ps1 != null) {
                    ps1.close();
                }
            } catch (Exception t) {
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception t) {
            }
        }

    }

    public Transaction getTransaction(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Transaction retour = null;

        //connexion ﾃ� la base de donnﾃｩes
        try {

            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("SELECT * FROM transaction WHERE transaction.ID = ?");
            ps.setInt(1, id);
              
            //on exﾃｩcute la requﾃｪte
            //rs contient un pointeur situﾃｩ jusute avant la premiﾃｨre ligne retournﾃｩe
            rs = ps.executeQuery();
            //passe ﾃ� la premiﾃｨre (et unique) ligne retournﾃｩe 
            if (rs.next()) {
                retour = new Transaction(rs.getInt("ID"), rs.getDouble("Montant"), rs.getString("Categorie"), rs.getDate("Date_T"), rs.getInt("Personne"));
            }
            else
                System.out.println("not found");

        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            //fermeture du ResultSet, du PreparedStatement et de la Connection
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception t) {
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception t) {
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception t) {
            }
        }
        return retour;
    }

    public List<Transaction> getListeTransaction() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Transaction> retour = new ArrayList<Transaction>();

        //connexion ﾃ� la base de donnﾃｩes
        try {

            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("SELECT * FROM Transaction");

            //on exﾃｩcute la requﾃｪte
            rs = ps.executeQuery();
            //on parcourt les lignes du rﾃｩsultat
            while (rs.next()) {
                retour.add(new Transaction(rs.getInt("ID"), rs.getDouble("Montant"), rs.getString("Categorie"), rs.getDate("Date_T"), rs.getInt("Personne")));
            }

        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            //fermeture du rs, du preparedStatement et de la connexion
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception t) {
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception t) {
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception t) {
            }
        }
        return retour;

    }
    
    public void update(Transaction t)
    {
          Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Transaction retour = null;

        //connexion ﾃ� la base de donnﾃｩes
        try {

            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("UPDATE transaction set Montant=?, Categorie=? ,Date_T=?,Personne=? WHERE ID =?");
            ps.setDouble(1, t.getMontant());
            ps.setString(2, t.getCategorie());
            ps.setDate(3, t.getDate_T());
            ps.setInt(4, t.getPersonne());
             ps.setInt(5, t.getID());
            //on exﾃｩcute la requﾃｪte
            //rs contient un pointeur situﾃｩ jusute avant la premiﾃｨre ligne retournﾃｩe
           
               ps.executeUpdate();
            //passe ﾃ� la premiﾃｨre (et unique) ligne retournﾃｩe          

        } catch (Exception ee) {
            ee.printStackTrace();
        } 
    }

    public void importTransaction(String fileName) throws IOException {

        String excelFilePath = fileName;

        int batchSize = 20;

        Connection connection = null;

        try {
            long start = System.currentTimeMillis();

            FileInputStream inputStream = new FileInputStream(excelFilePath);

            Workbook workbook = new XSSFWorkbook(inputStream);

            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();

            connection = DriverManager.getConnection(URL, LOGIN, PASS);
            connection.setAutoCommit(false);

            String sql = "INSERT INTO Transaction (Montant, Categorie,Date_T,Personne) VALUES (?, ?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            int count = 0;

            rowIterator.next(); // skip the header row

            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();

                    int columnIndex = nextCell.getColumnIndex();

                    switch (columnIndex) {
                        case 0:
                            double Montant =Double.valueOf(nextCell.getNumericCellValue()) ;
                            statement.setDouble(1, Montant);
                            break;
                        case 1:
                            String Categorie = nextCell.getStringCellValue();
                            statement.setString(2, Categorie);
                        case 2:                         
                          //Date Date_T = Date.valueOf(nextCell.getLocalDateTimeCellValue().toString());
                           statement.setDate(3, Date.valueOf("2021-06-06"));
                            break;
                        case 3:
                            int Personne = (int) nextCell.getNumericCellValue();
                            statement.setInt(4, Personne);
                    }

                }

                statement.addBatch();

                if (count % batchSize == 0) {
                    statement.executeBatch();
                }

            }

            workbook.close();

            // execute the remaining queries
            statement.executeBatch();

            connection.commit();
            connection.close();

            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));

        } catch (IOException ex1) {
            System.out.println("Error reading file");
            ex1.printStackTrace();
        } catch (SQLException ex2) {
            System.out.println("Database error");
            ex2.printStackTrace();
        }
    }
}
