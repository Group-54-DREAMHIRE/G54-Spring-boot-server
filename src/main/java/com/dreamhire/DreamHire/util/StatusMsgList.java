package com.dreamhire.DreamHire.util;

import com.dreamhire.DreamHire.dto.SendMailStatusDTO;

public  class StatusMsgList {
    public static String shortlistMessage(SendMailStatusDTO sendMailStatusDTO){
        String message =
                        "Hi" + " " + sendMailStatusDTO.getCanName() + ",\n" +  "\n" +"\n" +

                        "Congratulations on being shortlisted for the" + " " + sendMailStatusDTO.getJobTitle()+ " " + "at" + " " + sendMailStatusDTO.getCompanyName() + "." +
                        "We are excited about the possibility of working with you.\n" + "\n" +
                                "As the next step in our selection process, we would like to schedule an" +
                                "interview to learn more about your skills and discuss your potential contributions" +
                                " to our team. To facilitate this process, we have set up a scheduling system that allows" +
                                " you to choose a convenient time slot for your interview." +
                                "\n" + "\n"+


                                "In the scheduling tool, you will find available time slots for the upcoming interviews. Choose" +
                                " a time that suits your schedule, and the system will automatically confirm the appointment. If" +
                                "none of the provided time slots work for you, please reply to this email, and we will do our" +
                                "best to accommodate your availability." +
                                "\n" + "\n"+


                                "We appreciate your prompt attention to this matter. If you encounter any issues or have" +
                                " questions, don't hesitate to reach out to us." +
                                "\n" + "\n"+

                                "We look forward to meeting you and discussing how your talents align with the opportunities" +
                                " at" + " " + sendMailStatusDTO.getCompanyName() + "." +
                                "\n" + "\n"+


                                "\n" + "\n"+
                                "Thank you, \n" +
                                "Best Regards, \n" + sendMailStatusDTO.getCompanyName() + ".";
        return message;
    }

    public static String applyMessage(SendMailStatusDTO sendMailStatusDTO){
        String message =
                "Hi" + " " + sendMailStatusDTO.getCanName() + ",\n" +  "\n" +"\n" +

                        "Thank you for submitting your application for the position of" + " " + sendMailStatusDTO.getJobTitle() + " " +"at" + " " + sendMailStatusDTO.getCompanyName() + "." +
                        "We will review your application in a timely manner and if there is a good fit for the role, we will contact you shortly.\n" +

                        "\n" + "\n"+
                        "Thank you, \n" +
                        "Best Regards, \n" +
                        sendMailStatusDTO.getCompanyName() + ".";
        return message;
    }

    public static String rejectMessage(SendMailStatusDTO sendMailStatusDTO){
        String message =
                "Hi" + " " + sendMailStatusDTO.getCanName() + ",\n" +  "\n" +"\n" +

                        "We appreciate your interest in"  + " " + sendMailStatusDTO.getCompanyName() +
                        " and the time you have invested in applying for the opening" + "." +  "\n" +"\n" +

                        "Though your profile is impressive, we regret to inform you that we cannot proceed with your application for the position of " + sendMailStatusDTO.getJobTitle() +
                        " Selecting a final candidate was difficult. However, " +
                        "  we have selected another candidate who best meets our current expectations. Our choice in no way reflects upon your excellent skills and abilities. " +  "\n" +"\n" +

                        " We like to thank you for talking to our team and giving us the opportunity to learn about your skills and accomplishments."  +  "\n" +"\n" +

                        "Please feel free to apply for open positions with us in the future. We wish you good luck with your job search and professional future endeavors!" +
                        "\n" + "\n"+

                        "Thank you, \n" +
                        "Best Regards, \n" +
                        sendMailStatusDTO.getCompanyName() + ".";
        return message;
    }
}
