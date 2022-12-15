import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main
{
         public void main(String[] args) {

             Task_1();
             Task_2();
         }
             static void Task_1()
        {
            String request = "select * from students where ";
            String filterData = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

            String[] pairs = filterData.split(",");
            int counter = pairs.length - 1;
            StringBuilder sb = new StringBuilder(request);

            for (int i = 0; i < pairs.length; i++) {
                String[] currentPair = pairs[i].split(":");
                String columnName = currentPair[0].trim().replace("\"", "").replace("{", "");
                String columnValue = currentPair[1].trim().replace("\"", "'").replace("}", "");

                if (!columnValue.equalsIgnoreCase("'null'")) {
                    sb.append(columnName).append("=").append(columnValue);
                    if (i < counter) {
                        sb.append(" AND ");
                    }
                } else {
                    counter--;
                }
                counter--;

            }
            System.out.println(sb);
        }
    static void Task_2()
    {
        int[] arr = {15, 13, 1, 9, 7, 11};

        boolean isSorted = false;
        int tmp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;

                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
                writeToLog(arr);
            }
        }
    }

    private static void writeToLog(int[] arr) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(Arrays.toString(arr));
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
    }



}