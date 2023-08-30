#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <winsock2.h>

void ErrorHandling(char *message);

int main(int argc, char **argv)
{
	WSADATA wsaData;
	SOCKET hSocket;
	char serverIp[50] = { 0 };
	char filePath[MAX_PATH] = { 0 };
	char endFlag[50] = { 0 };
	int serverPort = 0;
	int len, size;
	DWORD dw;
	char sendBuffer[4096] = { 0 };
	SOCKADDR_IN servAddr;
	HANDLE hFile = INVALID_HANDLE_VALUE;

	printf(" \n\n\t\t ���� ���� Ŭ���̾�Ʈ \n");
	printf("\n\t\t ������ ���� IP : ");
	scanf("%s", serverIp);
	printf("\n\t\t ������ ���� ��Ʈ��ȣ : ");
	scanf("%d", &serverPort);

	printf("\n\t\t %s:%d �� �����մϴ�! \n", serverIp, serverPort);


	if (WSAStartup(MAKEWORD(2, 2), &wsaData) != 0)
		ErrorHandling("WSAStartup() error!");

	hSocket = socket(PF_INET, SOCK_STREAM, 0); /* ���� ������ ���� ���� ���� */
	if (hSocket == INVALID_SOCKET)
		ErrorHandling("hSocketet() error");

	memset(&servAddr, 0, sizeof(servAddr));
	servAddr.sin_family = AF_INET;
	servAddr.sin_addr.s_addr = inet_addr(serverIp);
	servAddr.sin_port = htons(serverPort);

	if (connect(hSocket, (SOCKADDR*)&servAddr, sizeof(servAddr)) == SOCKET_ERROR) /* ������ ���� ��û */
		ErrorHandling("connect() error!");

	printf("\t\t ���ӿϷ� \n");

	printf("\n\t\t���� ���ϸ� �Ǵ� ��θ� �Է��ϼ���! : ");
	scanf("%s", filePath);

	send(hSocket, filePath, strlen(filePath), 0);  // ���ϸ� ����

	hFile = CreateFile(filePath, GENERIC_READ | GENERIC_WRITE, 0, 0,  // ���� ���� 
		OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, 0);

	if (hFile == INVALID_HANDLE_VALUE) ErrorHandling(" File Open Error!! ");

	size = GetFileSize(hFile, 0);  // ���� ������ ��� 

	send(hSocket, (char*)&size, sizeof(int), 0);	 // ���ϻ����� ���� 

	Sleep(100);

	len = 0;

	printf("\t\t ���� ������.....\n");

	while (size > 0)
	{
		ReadFile(hFile, sendBuffer, sizeof(sendBuffer), &dw, 0);

		send(hSocket, sendBuffer, dw, 0);

		size = size - dw;
	}

	printf("\t\t ���� ���� �Ϸ�!!\n");


	while (strcmp(endFlag, "end"))
	{
		len = recv(hSocket, endFlag, sizeof(endFlag), 0);
		endFlag[len] = 0;
	}

	closesocket(hSocket);
	WSACleanup();

	system("pause");
	return 0;
}

void ErrorHandling(char *message)
{
	fputs("\t\t", stderr);
	fputs(message, stderr);
	fputc('\n', stderr);
	exit(1);
}
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <winsock2.h>

void ErrorHandling(char *message);

int main(int argc, char **argv)
{
	WSADATA wsaData;
	SOCKET hSocket;
	char serverIp[50] = { 0 };
	char filePath[MAX_PATH] = { 0 };
	char endFlag[50] = { 0 };
	int serverPort = 0;
	int len, size;
	DWORD dw;
	char sendBuffer[4096] = { 0 };
	SOCKADDR_IN servAddr;
	HANDLE hFile = INVALID_HANDLE_VALUE;

	printf(" \n\n\t\t ���� ���� Ŭ���̾�Ʈ \n");
	printf("\n\t\t ������ ���� IP : ");
	scanf("%s", serverIp);
	printf("\n\t\t ������ ���� ��Ʈ��ȣ : ");
	scanf("%d", &serverPort);

	printf("\n\t\t %s:%d �� �����մϴ�! \n", serverIp, serverPort);


	if (WSAStartup(MAKEWORD(2, 2), &wsaData) != 0)
		ErrorHandling("WSAStartup() error!");

	hSocket = socket(PF_INET, SOCK_STREAM, 0); /* ���� ������ ���� ���� ���� */
	if (hSocket == INVALID_SOCKET)
		ErrorHandling("hSocketet() error");

	memset(&servAddr, 0, sizeof(servAddr));
	servAddr.sin_family = AF_INET;
	servAddr.sin_addr.s_addr = inet_addr(serverIp);
	servAddr.sin_port = htons(serverPort);

	if (connect(hSocket, (SOCKADDR*)&servAddr, sizeof(servAddr)) == SOCKET_ERROR) /* ������ ���� ��û */
		ErrorHandling("connect() error!");

	printf("\t\t ���ӿϷ� \n");

	printf("\n\t\t���� ���ϸ� �Ǵ� ��θ� �Է��ϼ���! : ");
	scanf("%s", filePath);

	send(hSocket, filePath, strlen(filePath), 0);  // ���ϸ� ����

	hFile = CreateFile(filePath, GENERIC_READ | GENERIC_WRITE, 0, 0,  // ���� ���� 
		OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, 0);

	if (hFile == INVALID_HANDLE_VALUE) ErrorHandling(" File Open Error!! ");

	size = GetFileSize(hFile, 0);  // ���� ������ ��� 

	send(hSocket, (char*)&size, sizeof(int), 0);	 // ���ϻ����� ���� 

	Sleep(100);

	len = 0;

	printf("\t\t ���� ������.....\n");

	while (size > 0)
	{
		ReadFile(hFile, sendBuffer, sizeof(sendBuffer), &dw, 0);

		send(hSocket, sendBuffer, dw, 0);

		size = size - dw;
	}

	printf("\t\t ���� ���� �Ϸ�!!\n");


	while (strcmp(endFlag, "end"))
	{
		len = recv(hSocket, endFlag, sizeof(endFlag), 0);
		endFlag[len] = 0;
	}

	closesocket(hSocket);
	WSACleanup();

	system("pause");
	return 0;
}

void ErrorHandling(char *message)
{
	fputs("\t\t", stderr);
	fputs(message, stderr);
	fputc('\n', stderr);
	exit(1);
}
