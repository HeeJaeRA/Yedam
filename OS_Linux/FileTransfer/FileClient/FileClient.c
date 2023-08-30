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

	printf(" \n\n\t\t 파일 전송 클라이언트 \n");
	printf("\n\t\t 접속할 서버 IP : ");
	scanf("%s", serverIp);
	printf("\n\t\t 접속할 서버 포트번호 : ");
	scanf("%d", &serverPort);

	printf("\n\t\t %s:%d 로 접속합니다! \n", serverIp, serverPort);


	if (WSAStartup(MAKEWORD(2, 2), &wsaData) != 0)
		ErrorHandling("WSAStartup() error!");

	hSocket = socket(PF_INET, SOCK_STREAM, 0); /* 서버 접속을 위한 소켓 생성 */
	if (hSocket == INVALID_SOCKET)
		ErrorHandling("hSocketet() error");

	memset(&servAddr, 0, sizeof(servAddr));
	servAddr.sin_family = AF_INET;
	servAddr.sin_addr.s_addr = inet_addr(serverIp);
	servAddr.sin_port = htons(serverPort);

	if (connect(hSocket, (SOCKADDR*)&servAddr, sizeof(servAddr)) == SOCKET_ERROR) /* 서버로 연결 요청 */
		ErrorHandling("connect() error!");

	printf("\t\t 접속완료 \n");

	printf("\n\t\t전송 파일명 또는 경로를 입력하세요! : ");
	scanf("%s", filePath);

	send(hSocket, filePath, strlen(filePath), 0);  // 파일명 전송

	hFile = CreateFile(filePath, GENERIC_READ | GENERIC_WRITE, 0, 0,  // 파일 오픈 
		OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, 0);

	if (hFile == INVALID_HANDLE_VALUE) ErrorHandling(" File Open Error!! ");

	size = GetFileSize(hFile, 0);  // 파일 사이즈 계산 

	send(hSocket, (char*)&size, sizeof(int), 0);	 // 파일사이즈 전송 

	Sleep(100);

	len = 0;

	printf("\t\t 파일 전송중.....\n");

	while (size > 0)
	{
		ReadFile(hFile, sendBuffer, sizeof(sendBuffer), &dw, 0);

		send(hSocket, sendBuffer, dw, 0);

		size = size - dw;
	}

	printf("\t\t 파일 전송 완료!!\n");


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

	printf(" \n\n\t\t 파일 전송 클라이언트 \n");
	printf("\n\t\t 접속할 서버 IP : ");
	scanf("%s", serverIp);
	printf("\n\t\t 접속할 서버 포트번호 : ");
	scanf("%d", &serverPort);

	printf("\n\t\t %s:%d 로 접속합니다! \n", serverIp, serverPort);


	if (WSAStartup(MAKEWORD(2, 2), &wsaData) != 0)
		ErrorHandling("WSAStartup() error!");

	hSocket = socket(PF_INET, SOCK_STREAM, 0); /* 서버 접속을 위한 소켓 생성 */
	if (hSocket == INVALID_SOCKET)
		ErrorHandling("hSocketet() error");

	memset(&servAddr, 0, sizeof(servAddr));
	servAddr.sin_family = AF_INET;
	servAddr.sin_addr.s_addr = inet_addr(serverIp);
	servAddr.sin_port = htons(serverPort);

	if (connect(hSocket, (SOCKADDR*)&servAddr, sizeof(servAddr)) == SOCKET_ERROR) /* 서버로 연결 요청 */
		ErrorHandling("connect() error!");

	printf("\t\t 접속완료 \n");

	printf("\n\t\t전송 파일명 또는 경로를 입력하세요! : ");
	scanf("%s", filePath);

	send(hSocket, filePath, strlen(filePath), 0);  // 파일명 전송

	hFile = CreateFile(filePath, GENERIC_READ | GENERIC_WRITE, 0, 0,  // 파일 오픈 
		OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, 0);

	if (hFile == INVALID_HANDLE_VALUE) ErrorHandling(" File Open Error!! ");

	size = GetFileSize(hFile, 0);  // 파일 사이즈 계산 

	send(hSocket, (char*)&size, sizeof(int), 0);	 // 파일사이즈 전송 

	Sleep(100);

	len = 0;

	printf("\t\t 파일 전송중.....\n");

	while (size > 0)
	{
		ReadFile(hFile, sendBuffer, sizeof(sendBuffer), &dw, 0);

		send(hSocket, sendBuffer, dw, 0);

		size = size - dw;
	}

	printf("\t\t 파일 전송 완료!!\n");


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
