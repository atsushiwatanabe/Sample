// �w�b�_�t�@�C���̃C���N���[�h
#include <windows.h>	// �W��WindowsAPI
#include <tchar.h>		// TCHAR�^
#include <stdio.h>		// �W�����o��

// �X���b�h�̈����Ƃ��ēn���\����THREAD_PARAM�̒�`.
typedef struct{
	int m_iNo;					// �X���b�h�ԍ�
	TCHAR m_tszMessage[32];		// �X���b�h���o�͂��郁�b�Z�[�W.
	CRITICAL_SECTION *m_pCS;	// �N���e�B�J���Z�N�V�����\���̃|�C���^m_pCS.
}THREAD_PARAM;	// �����THREAD_PARAM�^�̊���.

// ThreadProc�֐��̒�`
DWORD WINAPI ThreadProc(LPVOID lpParameter){

	// �ϐ��̐錾
	int i;	// ���[�v�p�ϐ�i
	THREAD_PARAM *pTP;	// THREAD_PARAM�^�|�C���^pTP.

	// ����lpParameter��THREAD_PARAM�^�̃|�C���^�ɃL���X�g.
	pTP = (THREAD_PARAM *)lpParameter;	// lpParameter��THREAD_ARG�^�̃|�C���^�ɃL���X�g����, pTP�Ɋi�[.

	// �N���e�B�J���Z�N�V�����̊J�n.
	EnterCriticalSection(pTP->m_pCS);	// EnterCriticalSection�ł��������̓N���e�B�J���Z�N�V�����I�u�W�F�N�g���擾�ł���܂őҋ@.

	// 1����5�܂ł��o��.
	for (i = 1; i <= 5; i++){	// 1����5�܂�5��J��Ԃ�.

		// i, pTP->m_iNo, pTP->m_tszMessage���o��.
		_tprintf(_T("i = %d, m_iNo = %d, m_tszMessage = %s\n"), i, pTP->m_iNo, pTP->m_tszMessage);	// _tprintf��i, pTP->m_iNo, pTP->m_tszMessage�̒l���o��.
		Sleep(1000);	// Sleep��1�b�x�~.

	}

	// �N���e�B�J���Z�N�V�����̏I��.
	LeaveCriticalSection(pTP->m_pCS);	// LeaveCriticalSection�ł����ŃN���e�B�J���Z�N�V�����I�u�W�F�N�g�����.

	// �X���b�h�̏I��
	ExitThread((DWORD)pTP->m_iNo);	// ExitThread��pTP->m_iNo��(DWORD)�ɃL���X�g�������̂�n���ăX���b�h���I������.

}

// _tmain�֐��̒�`
int _tmain(int argc, TCHAR *argv[]){	// main�֐���TCHAR��.

	// �z��̐錾
	HANDLE hThread[5];		// HANDLE�^�X���b�h�n���h���z��hThread(�v�f��5)
	DWORD dwThreadId[5];	// DWORD�^�X���b�hID�z��dwThreadId(�v�f��5)
	THREAD_PARAM tp[5];		// �����Ƃ��ēn��THREAD_PARAM�^�z��tp.(�v�f��5)
	int i;					// ���[�v�p�ϐ�i.
	DWORD dwExitCode[5];	// DWORD�^�I���R�[�h�z��dwExitCode(�v�f��5)
	CRITICAL_SECTION cs;	// �N���e�B�J���Z�N�V�����\���̕ϐ�cs.

	// �N���e�B�J���Z�N�V�����\���̂̏�����.
	InitializeCriticalSection(&cs);	// InitializeCriticalSection��cs��������.

	// �X���b�h�̈�ĊJ�n
	tp[0].m_iNo = 0;	// m_iNo = 0
	_tcscpy(tp[0].m_tszMessage, _T("No.0"));	// m_tszMessage = "No.0"
	tp[0].m_pCS = &cs;	// cs�̃A�h���X��m_pCS�ɃZ�b�g.
	hThread[0] = CreateThread(NULL, 0, ThreadProc, &tp[0], 0, &dwThreadId[0]);	// CreateThread�ŃX���b�h�����y�ъJ�n.(������tp[0]��n���Ă���.)
	tp[1].m_iNo = 1;	// m_iNo = 1
	_tcscpy(tp[1].m_tszMessage, _T("No.1"));	// m_tszMessage = "No.1"
	tp[1].m_pCS = &cs;	// cs�̃A�h���X��m_pCS�ɃZ�b�g.
	hThread[1] = CreateThread(NULL, 0, ThreadProc, &tp[1], 0, &dwThreadId[1]);	// CreateThread�ŃX���b�h�����y�ъJ�n.(������tp[1]��n���Ă���.)
	tp[2].m_iNo = 2;	// m_iNo = 2
	_tcscpy(tp[2].m_tszMessage, _T("No.2"));	// m_tszMessage = "No.2"
	tp[2].m_pCS = &cs;	// cs�̃A�h���X��m_pCS�ɃZ�b�g.
	hThread[2] = CreateThread(NULL, 0, ThreadProc, &tp[2], 0, &dwThreadId[2]);	// CreateThread�ŃX���b�h�����y�ъJ�n.(������tp[2]��n���Ă���.)
	tp[3].m_iNo = 3;	// m_iNo = 3
	_tcscpy(tp[3].m_tszMessage, _T("No.3"));	// m_tszMessage = "No.3"
	tp[3].m_pCS = &cs;	// cs�̃A�h���X��m_pCS�ɃZ�b�g.
	hThread[3] = CreateThread(NULL, 0, ThreadProc, &tp[3], 0, &dwThreadId[3]);	// CreateThread�ŃX���b�h�����y�ъJ�n.(������tp[3]��n���Ă���.)
	tp[4].m_iNo = 4;	// m_iNo = 4
	_tcscpy(tp[4].m_tszMessage, _T("No.4"));	// m_tszMessage = "No.4"
	tp[4].m_pCS = &cs;	// cs�̃A�h���X��m_pCS�ɃZ�b�g.
	hThread[4] = CreateThread(NULL, 0, ThreadProc, &tp[4], 0, &dwThreadId[4]);	// CreateThread�ŃX���b�h�����y�ъJ�n.(������tp[4]��n���Ă���.)

	// �S�ẴX���b�h���V�O�i����ԂɂȂ�܂őҋ@.
	WaitForMultipleObjects(5, hThread, TRUE, INFINITE);	// WaitForMultipleObjects�ŃX���b�h�n���h���z��hThread�̂��ׂẴX���b�h���V�O�i����ԂɂȂ�܂őҋ@.

	// �I���R�[�h�擾.
	for (i = 0; i < 5; i++){	// 5��J��Ԃ�.

		// i�ԖڃX���b�h�̏I���R�[�h���擾.
		GetExitCodeThread(hThread[i], &dwExitCode[i]);	// GetExitCodeThread�Ŋe�X���b�h�̏I���R�[�h���擾.
		_tprintf(_T("dwExitCode[%d] = %lu\n"), i, dwExitCode[i]);	// dwExitCode[i]�̒l���o��.
		if (hThread[i] != NULL){	// hThread[i]��NULL�łȂ�.
			CloseHandle(hThread[i]);	// CloseHandle��hThread[i]�����.
		}

	}

	// �N���e�B�J���Z�N�V�����\���̂̍폜.
	DeleteCriticalSection(&cs);	// DeleteCriticalSection��cs���폜.

	// �v���O�����̏I��
	return 0;

}