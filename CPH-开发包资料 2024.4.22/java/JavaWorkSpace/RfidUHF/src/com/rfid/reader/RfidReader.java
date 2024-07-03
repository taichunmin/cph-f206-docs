package com.rfid.reader;

import java.io.IOException;
import com.rfid.transport.Transport;

public abstract class RfidReader {
	private static final int MAX_RECV_BUFF_SIZE = 1024;
	private static final int MAX_SEND_BUFF_SIZE = 128;
	private String key;
	public void setKey(String key) {
		this.key = key;
	}
	public byte[] recvMsgBuff;	//���ն�д�����͹���������
	public int recvMsgLen;	//���յ������ݳ���
	private AppNotify appNotify;	//���յ���Ӧ�������ϱ�Ӧ�ò��Ӧ��
	protected byte[] sendMsgBuff;
	protected int sendIndex;
	public int recvLen = 0;
	protected Transport transport = null;	//the type of communication with reader
	protected int connectType = 0;
	
	public RfidReader() {
		recvMsgBuff = new byte[MAX_RECV_BUFF_SIZE];
		sendMsgBuff = new byte[MAX_SEND_BUFF_SIZE];
	}
	
	public AppNotify getAppNotify() {
		return appNotify;
	}

	public void setAppNotify(AppNotify appNotify) {
		this.appNotify = appNotify;
	}
	
	public String getKey() {
		return key;
	}
	
	public int getUnsignedByte (byte data){ //��data�ֽ�������ת��Ϊ0~255 (0xFF ��BYTE)�� 
		return data&0x0FF ; 
	}
	
	public void setTransport(Transport transport)
	{
		this.transport = transport;
	}
	public Transport getTransport(){
		return transport;
	}
	
	public abstract int Inventory() throws IOException;	//��ʼ��Ѱ��ǩ
	public abstract int InventoryOnce() throws IOException;	//ֻ��Ѱһ��
	public abstract int Stop() throws IOException;	//ֹͣ����ǩ
	public abstract int Reboot() throws IOException;	//��ʱģʽ���������豸��ʼ����ǩ
	public abstract int ReadTagBlock(byte membank,byte addr,byte len) throws IOException;	//��ȡ��ǩ�е�ĳ����������
	//��membank������ʼ��ַΪaddr��������д�볤��len*2���ֽڵ����ݣ���д���������ʼλ��ΪwrittenData��writeStartIndex��λ��
	public abstract int WriteTagBlock(byte membank,byte addr,byte len, byte[] writtenData,int writeStartIndex) throws IOException;
	public abstract int LockTag(byte lockType) throws IOException;	//������ǩ���������޷��޸ı�ǩ����
	public abstract int KillTag() throws IOException;	//���ٱ�ǩʹ��ǩ���ٱ���ȡ
	public abstract int HandleRecv() throws IOException;	//��⵽�������ݺ������Ϣ
	public abstract void HandleMessage();	//������յ�����Ϣ
	protected abstract void NotifyMessageToApp(byte[] message,int startIndex);
}
