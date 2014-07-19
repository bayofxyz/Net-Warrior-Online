package Server;

import java.io.*;
import java.net.*;
import java.util.HashMap;

public class Network {
	private Socket client = null;
	private HashMap<Character, String> thaiCharKey;
	public Network(Socket client) {
		this.client = client;
		this.thaiCharKey = new HashMap<Character, String>();
        this.thaiCharKey.put('�', "'161'");
        this.thaiCharKey.put('�', "'162'");
        this.thaiCharKey.put('�', "'163'");
        this.thaiCharKey.put('�', "'164'");
        this.thaiCharKey.put('�', "'165'");
        this.thaiCharKey.put('�', "'166'");
        this.thaiCharKey.put('�', "'167'");
        this.thaiCharKey.put('�', "'168'");
        this.thaiCharKey.put('�', "'169'");
        this.thaiCharKey.put('�', "'170'");
        this.thaiCharKey.put('�', "'171'");
        this.thaiCharKey.put('�', "'172'");
        this.thaiCharKey.put('�', "'173'");
        this.thaiCharKey.put('�', "'174'");
        this.thaiCharKey.put('�', "'175'");
        this.thaiCharKey.put('�', "'176'");
        this.thaiCharKey.put('�', "'177'");
        this.thaiCharKey.put('�', "'178'");
        this.thaiCharKey.put('�', "'179'");
        this.thaiCharKey.put('�', "'180'");
        this.thaiCharKey.put('�', "'181'");
        this.thaiCharKey.put('�', "'182'");
        this.thaiCharKey.put('�', "'183'");
        this.thaiCharKey.put('�', "'184'");
        this.thaiCharKey.put('�', "'185'");
        this.thaiCharKey.put('�', "'186'");
        this.thaiCharKey.put('�', "'187'");
        this.thaiCharKey.put('�', "'188'");
        this.thaiCharKey.put('�', "'189'");
        this.thaiCharKey.put('�', "'190'");
        this.thaiCharKey.put('�', "'191'");
        this.thaiCharKey.put('�', "'192'");
        this.thaiCharKey.put('�', "'193'");
        this.thaiCharKey.put('�', "'194'");
        this.thaiCharKey.put('�', "'195'");
        this.thaiCharKey.put('�', "'196'");
        this.thaiCharKey.put('�', "'197'");
        this.thaiCharKey.put('�', "'198'");
        this.thaiCharKey.put('�', "'199'");
        this.thaiCharKey.put('�', "'200'");
        this.thaiCharKey.put('�', "'201'");
        this.thaiCharKey.put('�', "'202'");
        this.thaiCharKey.put('�', "'203'");
        this.thaiCharKey.put('�', "'204'");
        this.thaiCharKey.put('�', "'205'");
        this.thaiCharKey.put('�', "'206'");
        this.thaiCharKey.put('�', "'207'");
        this.thaiCharKey.put('�', "'208'");
        this.thaiCharKey.put('�', "'209'");
        this.thaiCharKey.put('�', "'210'");
        this.thaiCharKey.put('�', "'211'");
        this.thaiCharKey.put('�', "'212'");
        this.thaiCharKey.put('�', "'213'");
        this.thaiCharKey.put('�', "'214'");
        this.thaiCharKey.put('�', "'215'");
        this.thaiCharKey.put('�', "'216'");
        this.thaiCharKey.put('�', "'217'");
        this.thaiCharKey.put('�', "'218'");
        this.thaiCharKey.put('�', "'223'");
        this.thaiCharKey.put('�', "'224'");
        this.thaiCharKey.put('�', "'225'");
        this.thaiCharKey.put('�', "'226'");
        this.thaiCharKey.put('�', "'227'");
        this.thaiCharKey.put('�', "'228'");
        this.thaiCharKey.put('�', "'229'");
        this.thaiCharKey.put('�', "'230'");
        this.thaiCharKey.put('�', "'231'");
        this.thaiCharKey.put('�', "'232'");
        this.thaiCharKey.put('�', "'233'");
        this.thaiCharKey.put('�', "'234'");
        this.thaiCharKey.put('�', "'235'");
        this.thaiCharKey.put('�', "'236'");
        this.thaiCharKey.put('�', "'237'");
        this.thaiCharKey.put('�', "'238'");
        this.thaiCharKey.put('�', "'239'");
        this.thaiCharKey.put('�', "'240'");
        this.thaiCharKey.put('�', "'241'");
        this.thaiCharKey.put('�', "'242'");
        this.thaiCharKey.put('�', "'243'");
        this.thaiCharKey.put('�', "'244'");
        this.thaiCharKey.put('�', "'245'");
        this.thaiCharKey.put('�', "'246'");
        this.thaiCharKey.put('�', "'247'");
        this.thaiCharKey.put('�', "'248'");
        this.thaiCharKey.put('�', "'249'");
        this.thaiCharKey.put('�', "'250'");
        this.thaiCharKey.put('�', "'251'");
	}

    public void Connect(SocketAddress ip, int port)
    {
        try {
			client.connect(ip, port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void Close()
    {
        try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public Boolean isConnected()
    {
        return client.isConnected();
    }

    public Boolean isClosed()
    {
        return client.isClosed();
    }

    public void Send(String message)
    {
    	if (client.isConnected() && !client.isClosed()) {
	        try
	        {
	        	OutputStream output = client.getOutputStream();
	        	output.write(convertThaiCharToCode(message).getBytes());
	        	output.flush();
	        }
	        catch (Exception e)
	        {
	        }
    	}
    }

    public String Receive()
    {
        String responseMsg = "";
    	if (client.isConnected() && !client.isClosed()) {
	        try
	        {
	            InputStream input = client.getInputStream();
	            if (input.available() > 0) {
	                byte[] byteInput = new byte[input.available()];
	                int reads = input.read(byteInput, 0, byteInput.length);
	                if(reads < byteInput.length)	//Just to be sure, not necessary I think
	                {
	                    byte[] byteInput_ = new byte[reads];
	                    System.arraycopy(byteInput, 0, byteInput_, 0, reads);
	                    byteInput = byteInput_;
	                }
	                responseMsg = new String(byteInput);
	            }
	            //System.Console.WriteLine(responseMsg);
	        }
	        catch (Exception e)
	        {
	        }
    	}
        return responseMsg;
    }
    
    public InputStream getInputStream() {
    	try {
			return client.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
    }
    
    public OutputStream getOutputStream() {
    	try {
			return client.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
    }
    
    private String convertThaiCharToCode(String input)
    {
        String output = input;
        for (Character key : this.thaiCharKey.keySet())
        {
            output = output.replace(String.valueOf(key), this.thaiCharKey.get(key));
        }
        return output;
    }
}
