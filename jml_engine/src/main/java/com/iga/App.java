package com.iga;

import com.iga.model.Identity;
import com.iga.service.JMLEngine;
import com.iga.util.DbClient; // Ensure this utility is created
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // IMPORTANT: Create the tables in the target system first
        DbClient.initDatabase();

        JMLEngine engine = new JMLEngine();

        try {
            List<Identity> hrUpdates = new CsvToBeanBuilder<Identity>(new FileReader("hr_data.csv"))
                    .withType(Identity.class)
                    .build()
                    .parse();

            System.out.println("--- Starting IGA Reconciliation Cycle ---");
            for (Identity user : hrUpdates) {
                engine.processIdentity(user);
            }
            System.out.println("--- Cycle Complete ---");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}