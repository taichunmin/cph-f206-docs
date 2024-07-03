package com.rfid.reader;

//���յ���Ӧ��֪ͨ�ϲ㴦��Ľӿ�
public interface AppNotify {
	public int NotifyRecvOneTag(RfidReader reader,String epcData,String tidData);	//�ϱ���ȡ����ǩ����

	public void NotifyNewTcpConnectAvailable(RfidReader reader);
	public void NotifyRemoteCloseConnection(RfidReader reader);
	
	public void NotifyRebootRsp(RfidReader reader, int status);	//�ϱ�����������豸��������Զ�����ǩ
	public void NotifySetDefaultParamRsp(RfidReader reader, int status);	//�ϱ�����������豸��������Զ�����ǩ
	public void NotifyStartInventoryRsp(RfidReader reader, int status);	//�ϱ���ʼ��Ѱ�Ľ��
	public void NotifyStopInventoryRsp(RfidReader reader, int status);
	//public void NotifySetWorkParamRsp(RfidReader reader, int status);	//�ϱ����ù�������
	public void NotifyWriteTagRsp(RfidReader reader, int status);
	public void NotifyReadTagRsp(RfidReader reader,int status,byte[] readTagData);
}
