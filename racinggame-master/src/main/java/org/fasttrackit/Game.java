package org.fasttrackit;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    // instantiem un sir de obiecte
    private Track[] tracks = new Track[3];

    private List<Vehicle> competitors = new ArrayList<>();


    public void start(){
        System.out.println("Starting Game...");

        initializeTraks();
        displayTracks();

        initiliazeCompetitors();

        // enhaced for
        for (Vehicle vehicle : competitors) {
            System.out.println("It`s "+ vehicle.getName() + "`s turn.");

        }

    }

    private void initializeTraks(){

        Track track1 = new Track();
        track1.setName("Silverstone");
        track1.setLenght(4.2);
        // prima pozitie din sir este tot timpu "0"
        tracks [0] = track1;

        Track track2 = new Track();
        track2.setName("HungaroRing");
        track2.setLenght(450.88);
        tracks[1]= track2;
    }


    private void initiliazeCompetitors(){
        int playerCount = getPlayerCountFromUser();
        System.out.println("Number of players:"+ playerCount);

        String vehicleName = getVehicleNameFromUser();
        System.out.println("Name from user: " + vehicleName);

        for (int i = 1; i <= playerCount; i++) {
            System.out.println(" Adding player " + i);

            Vehicle vehicle = new Vehicle();
            vehicle.setName(getVehicleNameFromUser());
            vehicle.setFuelLevel(80);
            vehicle.setMileage(ThreadLocalRandom.current().nextDouble(6, 15));
            vehicle.setMaxSpeed(300);
            System.out.println(" Vehicle for player " + i + " :" + vehicle.getName() + " - Mileage " + vehicle.getMileage());

            competitors.add(vehicle);
        }
    }

    private void displayTracks(){
        System.out.println("Available tracks: ");

        // clasic for loop
        // cand punem conditia sa nu uit de faptul ca 3 inseamna 0,1,2
        for (int i = 0; i < tracks.length; i++){

            if (tracks[i] != null) {
                System.out.println((i+1) + "." + tracks[i].getName() + "-" + tracks[i].getLenght()+"Km");
            }
        }

    }

    private String getVehicleNameFromUser(){
        System.out.println("Please enter vehicle name.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    private int getPlayerCountFromUser(){
        System.out.println("Please enter vehicle count.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();


    }
}
