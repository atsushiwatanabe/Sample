/* ヘッダファイルのインクルード */
#include <stdio.h> /* 標準入出力 */
#include <string.h> /* 文字列操作 */
#include <ctype.h> /* 文字操作 */

/* main関数の定義 */
int main(void){

  /* 変数, 配列の初期化 */
  int len = 0; /* textの長さlenを0に初期化. */
  int i = 0; /* iを0に初期化. */
  char text[256] = {'\0'}; /* textを'\0'で埋める. */

  /* 文字列の取得 */
  fgets(text, 256, stdin); /* 標準入力stdinからfgetsで1行読み込み, textに格納. */

  /* 最後の文字をチェック. */
  len = strlen(text); /* textの長さを取得. */
  if (text[len - 1] == '\n'){ /* 最後の文字が'\n'. */
    text[len - 1] = '\0'; /* '\0'を代入. */
  }
  len = strlen(text); /* もう一度長さを取得.(改行がなくなった分減っている.) */

  /* アルファベットでもない数字でもない記号などの文字が含まれているかをチェック. */
  for (i = 0; i < len; i++){ /* lenの分だけ繰り返す. */
    if (!isalnum(text[i])){ /* textのi番目がisalnumによってアルファベットでも数字でもないことがわかった時. */
      printf("Not a alphabet and Not a digit.\n"); /* "Not a alphabet and Not a digit.")と出力. */
      return 0; /* 0を返して正常終了. */
    }
  }

  /* アルファベットか数字の場合. */
  printf("A alphabet or a digit.\n"); /* "A alphabet or a digit."を出力. */

  /* プログラムの終了 */
  return 0; /* 0を返して正常終了. */

}