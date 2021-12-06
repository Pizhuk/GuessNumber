package main.com.services;

public class GameService {
    public String startGame(int number, String answer, int count, int amountOfAttempts, int[] helpArray){
        String numberToTxt = number+"";
        String txt = "";
        if(numberToTxt.equalsIgnoreCase(answer)){
            txt = "Поздравляю! Ты угадал задуманное число за "+count +" попыток";
        }
        else if(count == amountOfAttempts){
            txt = "Вы не отгадали число!";
        }
        else if(!numberToTxt.equalsIgnoreCase(answer) && count == 1){
            helpArray[count-1] = Integer.parseInt(answer);
            txt = "Не угадал. Осталось "+(amountOfAttempts-count) +" попыток";
        }
        else if(!numberToTxt.equalsIgnoreCase(answer) && count > 1){
            helpArray[count-1] = Integer.parseInt(answer);
            if (Math.abs(helpArray[count-1]-number) >= Math.abs(helpArray[count-2]-number)){
                txt = "Не угадал, холоднее… Осталось "+(amountOfAttempts-count) +" попыток";

            }
            else if(Math.abs(helpArray[count-1]-number) < Math.abs(helpArray[count-2]-number)){
                txt = "Не угадал, теплее… Осталось "+(amountOfAttempts-count) +" попыток";
            }
        }
        return txt;
    }
}
