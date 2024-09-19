package practice;

import java.util.Scanner;

public class VideoStore {

  private Video[] videos;
  private int numVideos;

  public VideoStore(int capacity) {
    this.videos = new Video[capacity];
    this.numVideos = 0;
  }

  public void addVideo(String name) {
    if (numVideos < videos.length) {
      videos[numVideos] = new Video(name);
      numVideos++;
      System.out.println(name + " added to inventory.");
    } else {
      System.out.println("Inventory full!");
    }
  }

  public void doCheckout(String name) {
    for (int i = 0; i < numVideos; i++) {
      if (videos[i].getName().equals(name) && videos[i].isAvailable()) {
        videos[i].setAvailable(false);
        System.out.println(name + " checked out successfully.");
        return;
      }
    }
    System.out.println(name + " not found or unavailable.");
  }

  public void doReturn(String name) {
    for (int i = 0; i < numVideos; i++) {
      if (videos[i].getName().equals(name)) {
        videos[i].setAvailable(true);
        System.out.println(name + " returned.");
        return;
      }
    }
    System.out.println(name + " not found.");
  }

  public void receiveRating(String name, int rating) {
    for (int i = 0; i < numVideos; i++) {
      if (videos[i].getName().equals(name)) {
        videos[i].setRating(rating);
        System.out.println("Rating for " + name + " received: " + rating);
        return;
      }
    }
    System.out.println(name + " not found.");
  }

  public void listInventory() {
    System.out.println("Video Inventory:");
    for (int i = 0; i < numVideos; i++) {
      System.out.println(
          videos[i].getName() + " (Available: " + videos[i].isAvailable() + ", Rating: " + videos[i].getRating() + ")"
      );
    }
  }
}

class Video {
  private String name;
  private boolean available;
  private int rating;

  public Video(String name) {
    this.name = name;
    this.available = true;
    this.rating = 0;
  }

  public String getName() {
    return name;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }
}

public class VideoLauncher {
  public static void main(String[] args) {
    VideoStore store = new VideoStore(10);

    store.addVideo("Matrix");
    store.addVideo("Lord of the Rings");
    store.addVideo("The Godfather");

    int choice;
    String name;
    int rating;
    Scanner scanner = new Scanner(System.in);

    do {
      System.out.println("\nVideo Rental System Menu:");
      System.out.println("1. Add Videos");
      System.out.println("2. Check Out Videos");
      System.out.println("3. Return Videos");
      System.out.println("4. Receive Ratings");
      System.out.println("5. List Inventory");
      System.out.println("6. Exit");
      System.out.print("Enter your choice (1-6): ");
      choice = scanner.nextInt();
      scanner.nextLine(); // Consume the newline character after the integer input

      switch (choice) {
        case 1:
          System.out.print("Enter video name: ");
          name = scanner.nextLine();
          store.addVideo(name);
          break;
        case 2:
          System.out.print("Enter video name to check out: ");
          name = scanner.nextLine();
          store.doCheckout(name);
          break;
        case 3:
          System.out.print("Enter video name to return: ");
          name = scanner.nextLine();
          store.doReturn(name);
          break;
        case 4:
          System.out.print("Enter video name to rate: ");
          name = scanner.nextLine();
          System.out.print("Enter rating: ");
          rating = scanner.nextInt();
          scanner.nextLine(); // Consume the newline character after the integer input
          store.receiveRating(name, rating);
          break;
        case 5:
          store.listInventory();
          break;
        case 6:
          System.out.println("Exiting the system.");
          break;
        default:
          System.out.println("Invalid choice! Please enter a number between 1 and 6.");
      }
    } while (choice != 6);

    scanner.close();
  }
}
