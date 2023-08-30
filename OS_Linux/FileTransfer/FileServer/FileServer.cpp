#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <winsock2.h>

void ErrorHandling(char *message);

int main()
{
	WSADATA	wsaData;
	SOCKET hServSock;		
	SOCKET hClntSock;		
	SOCKADDR_IN servAddr;	
	SOCKADDR_IN clntAddr;		
	int szClntAddr;
	int len = 0 ;
	int openPort = 0 ;
	char filePath[MAX_PATH] = { 0 } ;
	char recvBuffer[4096] = { 0 } ;
	char* tmp = 0 ;
	HANDLE hFile = INVALID_HANDLE_VALUE ;
	DWORD dw ;
	
	int size = 0 ;
	int i = 0 ;


	printf("\n\n\t\t ���ϼ��� ���� \n " ) ;
	printf("\n\t\t ������ ��Ʈ ��ȣ : ");
	scanf("%d",&openPort);

	
	if(WSAStartup(MAKEWORD(2, 2), &wsaData) != 0) 
		ErrorHandling("WSAStartup() error!"); 
	
	hServSock=socket(PF_INET, SOCK_STREAM, 0); /* ���� ���� ���� */
	if(hServSock==INVALID_SOCKET)
		ErrorHandling("socket() error");
  
	memset(&servAddr, 0, sizeof(servAddr));
	servAddr.sin_family=AF_INET;
	servAddr.sin_addr.s_addr=htonl(INADDR_ANY);
	servAddr.sin_port=htons(openPort);
	
	if( bind(hServSock, (SOCKADDR*) &servAddr, sizeof(servAddr))==SOCKET_ERROR ) /* ���Ͽ� �ּ� �Ҵ� */
		ErrorHandling("bind() error");  
	
	if( listen(hServSock, 5)==SOCKET_ERROR) /* ���� ��û ��� ���� */
		ErrorHandling("listen() error");

	else printf("\n\t\t %d �� ��Ʈ ���� Ŭ���̾�Ʈ ���� �����.. \n",openPort);


	szClntAddr=sizeof(clntAddr);    	
	hClntSock=accept(hServSock, (SOCKADDR*)&clntAddr,&szClntAddr); /* ���� ��û ���� */
	if(hClntSock==INVALID_SOCKET)
		ErrorHandling("accept() error");  

	printf("\n\t\t Ŭ���̾�Ʈ ����Ȯ��! ���� ���Ŵ�� ��! \n");

	len = recv(hClntSock,filePath,sizeof(filePath)-1,0);  // ���ϸ� ���� 
	filePath[len] = 0 ; 
	tmp = strrchr(filePath,'\\');

	if ( tmp ) tmp++;
	else tmp = filePath;

	printf("\n\t\t ���� ���ϸ� : %s \n", tmp ) ;

	len = recv(hClntSock,(char*)&size,sizeof(int),0);  // ���� ������ ���� 

	printf("\t\t ���� ���� ������ : %d \n", size ) ;

	hFile = CreateFile(tmp,GENERIC_READ|GENERIC_WRITE,0,0,
		CREATE_ALWAYS,FILE_ATTRIBUTE_NORMAL,0);

	while(size > 0)
	{
		len = recv(hClntSock,recvBuffer,sizeof(recvBuffer),0);
		size = size - len;
		WriteFile(hFile,recvBuffer,len,&dw,0);
	}


	printf("\n\t\t ���� ���ſϷ�! \n");

	
	send(hClntSock,"end",strlen("end"),0);
	

	closesocket(hClntSock);	
	WSACleanup();


	return 0;
}

void ErrorHandling(char *message)
{
	fputs(message, stderr);
	fputc('\n', stderr);
	exit(1);
}

