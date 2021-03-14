import java.util.*;

class AsciiCharSequence implements java.lang.CharSequence {

    byte[] charSequence;

    public AsciiCharSequence(byte[] charSequence) {
        this.charSequence = charSequence.clone();
    }

    @Override
    public int length() {
        return charSequence.length;
    }

    @Override
    public char charAt(int i) {
        return (char) charSequence[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return new AsciiCharSequence(Arrays.copyOfRange(charSequence, i, i1));
    }

    @Override
    public String toString() {
        return new String(charSequence);
    }

}