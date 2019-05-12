/* ヘッダファイルのインクルード */
#include <stdio.h> /* 標準入出力 */
#include <stdlib.h> /* 標準ユーティリティ */
#include <time.h> /* UNIX時間 */

/* main関数の定義 */
int main(void){

  /* 変数の宣言 */
  int i; /* ループ用int型変数i */
  int r; /* 疑似乱数を格納するint型変数r.

  /* 乱数種(シード)を変更. */
  srand((unsigned int)time(NULL)); /* srandの引数にtimeの戻り値をセットする.(毎回起動時に変わるので, パターンも変わってくる.) */

  /* 0から99までの擬似乱数を発生させる. */
  for (i = 1; i <= 100; i++){ /* iが1から100まで繰り返す. */

    /* 0から99までの疑似乱数を取得. */
    r = rand() % 100; /* randの戻り値を100で割った余りをrに格納.(rは0から99までのどれかになる.) */

    /* rを出力. */
    printf("%2d ", r); /* printfでrを2桁で出力し, 後ろにスペースを空ける. */

    /* iが10の倍数の時, 改行する. */
    if (i % 10 == 0){ /* 10の倍数の時. */
      printf("\n"); /* printfで"\n"を出力して, 改行する. */
    }

  }

  /* プログラムの終了 */
  return 0; /* 0を返して正常終了. */

}