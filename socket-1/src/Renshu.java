class Renshu {
    // xを2倍にして返す関数
    public int doubleValue(int x) {
        return x * 2;
    }
    
    //1から n までの整数の合計値を返す。
    public int sumUpToN(int n) {
        return n * (n + 1) / 2;
    }
    
    //p から q までの整数の合計値を返す。
    public int sumFromPtoQ(int p, int q) {
        if (p > q) return -1;
        return sumUpToN(q) - sumUpToN(p - 1);
    }
    
    //配列 a[] の指定された index から以降の要素の合計値を返す。不正な index の場合は -1 を返す。
    public int sumFromArrayIndex(int[] array, int index) {
        if (index < 0 || index >= array.length) return -1;
        int sum = 0;
        for (int i = index; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
    
    //配列 a の中で最大の値を返す。
    public int selectMaxValue(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (value > max) max = value;
        }
        return max;
    }
    
    //配列 a の中で最小の値を返す。
    public int selectMinValue(int[] array) {
        int min = array[0];
        for (int value : array) {
            if (value < min) min = value;
        }
        return min;
    }
    
    //配列 a の中で最大の値が入っている要素の位置（index）を返す。最大値が複数の場合は最小のindexを返す。
    public int selectMaxIndex(int[] array) {
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    //配列 a の中で最小の値が入っている要素の位置（index）を返す。最小値が複数の場合は最小のindexを返す。
    public int selectMinIndex(int[] array) {
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
    
    //配列 p の i 番目と j 番目の要素を入れ替える。
    public void swapArrayElements(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    
    //同じ長さの二つの配列 a と b の内容を入れ替える。
    public boolean swapTwoArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) return false;
        for (int i = 0; i < array1.length; i++) {
            int temp = array1[i];
            array1[i] = array2[i];
            array2[i] = temp;
        }
        return true;
    }
}
