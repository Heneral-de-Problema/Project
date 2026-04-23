package Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Student {

    public static void main(String[] args) {

        int totalFeedbacks = 0;
        int totalRating = 0;
        int excellent = 0, good = 0, average = 0, poor = 0, veryPoor = 0;

        StringBuilder feedbackLog = new StringBuilder();
        feedbackLog.append("--- Student Feedback Records ---\n");

        boolean continueLoop = true;

        while (continueLoop) {


            String studentName = JOptionPane.showInputDialog(null,
                    "Enter Student Name:", "Student Feedback", JOptionPane.PLAIN_MESSAGE);
            if (studentName == null) System.exit(0);
            studentName = studentName.trim();
            if (studentName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Student name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            String course = JOptionPane.showInputDialog(null,
                    "Enter Course/Subject:", "Student Feedback", JOptionPane.PLAIN_MESSAGE);
            if (course == null) System.exit(0);
            course = course.trim();
            if (course.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Course cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            String feedback = JOptionPane.showInputDialog(null,
                    "Enter Feedback Message:", "Student Feedback", JOptionPane.PLAIN_MESSAGE);
            if (feedback == null) System.exit(0);
            feedback = feedback.trim();
            if (feedback.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Feedback message cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            String ratingInput = JOptionPane.showInputDialog(null,
                    "Enter Rating (1 = Very Poor, 2 = Poor, 3 = Average, 4 = Good, 5 = Excellent):",
                    "Student Feedback", JOptionPane.PLAIN_MESSAGE);
            if (ratingInput == null) System.exit(0);

            int rating;
            try {
                rating = Integer.parseInt(ratingInput.trim());
                if (rating < 1 || rating > 5) {
                    JOptionPane.showMessageDialog(null, "Rating must be between 1 and 5.", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid rating. Please enter a number from 1 to 5.", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            String category;
            switch (rating) {
                case 5: category = "Excellent";  excellent++; break;
                case 4: category = "Good";       good++;      break;
                case 3: category = "Average";    average++;   break;
                case 2: category = "Poor";       poor++;      break;
                default: category = "Very Poor"; veryPoor++;  break;
            }

            totalFeedbacks++;
            totalRating += rating;

            feedbackLog.append("\nStudent Name: ").append(studentName).append("\n");
            feedbackLog.append("Course: ").append(course).append("\n");
            feedbackLog.append("Feedback: ").append(feedback).append("\n");
            feedbackLog.append("Rating: ").append(rating).append(" (").append(category).append(")\n");

            int choice = JOptionPane.showConfirmDialog(null,
                    "Add another feedback entry?", "Continue?",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (choice == JOptionPane.CLOSED_OPTION) System.exit(0);
            if (choice == JOptionPane.NO_OPTION) continueLoop = false;
        }

        double averageRating = (totalFeedbacks > 0) ? (double) totalRating / totalFeedbacks : 0.0;

        feedbackLog.append("\n--------------------------\n");
        feedbackLog.append("Total Feedbacks: ").append(totalFeedbacks).append("\n");
        feedbackLog.append(String.format("Average Rating: %.1f%n", averageRating));
        feedbackLog.append("\nRating Summary:\n");
        feedbackLog.append("Excellent: ").append(excellent).append("\n");
        feedbackLog.append("Good: ").append(good).append("\n");
        feedbackLog.append("Average: ").append(average).append("\n");
        feedbackLog.append("Poor: ").append(poor).append("\n");
        feedbackLog.append("Very Poor: ").append(veryPoor).append("\n");

        String fileName = "feedback.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(feedbackLog.toString());
            writer.newLine();
            JOptionPane.showMessageDialog(null,
                    "Feedback saved successfully to \"" + fileName + "\"!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Error writing to file: " + e.getMessage(),
                    "File Error", JOptionPane.ERROR_MESSAGE);
        }

        JOptionPane.showMessageDialog(null,
                feedbackLog.toString(),
                "Feedback Summary", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}


