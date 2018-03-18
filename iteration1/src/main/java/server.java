import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.*;
import java.net.Socket;

public class server
{

    private static Socket socket;
    public static void main(String[] args)
    {
        Check check = new Check(2,"server","ASUS2");
        ServerTransport serverTransport = new ServerTransport();
        serverTransport.StartSocket();
        try
        {
//
            ObjectMapper mapper2 = new ObjectMapper();
            mapper2.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

            //Server is running always. This is done using this while(true) loop
            while(true)
            {
                //Reading the message from the client
                Check check2 = mapper2.readValue(serverTransport.receiveMessage(), Check.class);
                System.out.println("The POJO of the message received from the client is : "+check2);
                System.out.println("************************************************");

                ObjectMapper mapper3 = new ObjectMapper();
                mapper3.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
                String msgBack = mapper3.writeValueAsString(check);
                String returnMessage;

                try
                {
                    String returnValue = msgBack;
                    //System.out.println(returnValue);
                    returnMessage = String.valueOf(returnValue) + "\n";
                }
                catch(NumberFormatException e)
                {
                    //Input was not a number. Sending proper message back to client.
                    returnMessage = "Please send a proper number\n";
                }

                   //Sending the response back to the client.
                    ServerTransport.sendMessage(returnMessage);
            }

        }
        catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        finally
        {
            serverTransport.StopSocket();
            try
            {
//                socket.close();
            }
            catch(Exception e){}
        }
    }
}