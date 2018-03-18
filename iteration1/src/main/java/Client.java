import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.*;
import java.net.Socket;

public class Client
{
    private static Socket socket;

    public static void main(String args[])
    {
        Check check = new Check(1, "Client", "ASUS1");
        ClientTransport clientTransport = new ClientTransport();
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            String number = mapper.writeValueAsString(check);
            clientTransport.SendToServer(number);
            ObjectMapper mapper2 = new ObjectMapper();
            mapper2.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            String receivedJson = clientTransport.RcvFromServer();
            Check check1 = mapper2.readValue(receivedJson, Check.class);

            //  System.out.println(String.valueOf(receivedJson));
            System.out.println("The POJO of the message from server is : "+String.valueOf(check1));
        }

        catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e)
        {   e.printStackTrace();}



        finally
        {
            //Closing the socket
            try
            {
                clientTransport.StopSocket();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

}