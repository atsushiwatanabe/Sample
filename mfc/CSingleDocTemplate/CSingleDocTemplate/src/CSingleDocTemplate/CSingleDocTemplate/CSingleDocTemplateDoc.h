// CSingleDocTemplateDoc.h : CSingleDocTemplateDoc �N���X�̃C���^�[�t�F�C�X
//


#pragma once


class CSingleDocTemplateDoc : public CDocument
{
protected: // �V���A��������̂ݍ쐬���܂��B
	CSingleDocTemplateDoc();
	DECLARE_DYNCREATE(CSingleDocTemplateDoc)

// ����
public:

// ����
public:

// �I�[�o�[���C�h
public:
	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);

// ����
public:
	virtual ~CSingleDocTemplateDoc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// �������ꂽ�A���b�Z�[�W���蓖�Ċ֐�
protected:
	DECLARE_MESSAGE_MAP()
};

