/**
 * Copyright (c) 2007 Regents of the University of California.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * 3. The name of the University may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */

package io.grpc.examples.p4p.p4p.util;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.security.MessageDigest;
import java.security.GeneralSecurityException;

public class Util extends P4PParameters {
    public static SecureRandom rand = new SecureRandom();

    // Warming up:
    static {
        rand.nextBoolean();
    }

    private static int t = 20;
    /**
     * This parameter controls how "close" our random numbers generated by the
     * following two functions are to a true uniform distribution over
     * [0, ..., q-1). We essentially generate t more random bites and do mod q.
     * The statisical distance to a true uniform distribution is 2^{-t}. See
     *
     *   Victor Shoup, A Computational Introduction to Number Theory
     *   and Algebra, pp 157. http://www.shoup.net/ntb/
     */

    /**
     * Randomly generates a <code>BigInteger</code> between 1 to n-1, inclusive.
     *
     * @param	m	the size of the set
     * @return	a BigInteger uniformly randomly distributed between [1, n-1]
     */
    public static BigInteger randomBigInteger(BigInteger m) {
        while(true) {
            BigInteger r = new BigInteger(m.bitLength()+t, rand);
            if(!r.equals(BigInteger.ZERO))
                return r.mod(m);
        }
    }


    /**
     * A hash function mapping the message to an element in Z_q. We just
     * compute SHA-512 hash of the messages and catenate them until we have
     * enough bits.
     *
     * @param	msg	the array of messages
     * @param	q	the size of the set
     * @return	an element in Z_q which is a hash of the given messages.
     *
     */
    public static BigInteger secureHash(BigInteger[] msg, BigInteger q)
            throws GeneralSecurityException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        final int HASH_LENGTH = md.getDigestLength();
        // The length of the hash in bytes
        int k = q.bitLength()+1;
        // The required length of output in bits

        int nRounds = k/(HASH_LENGTH*8+t)+1;
        byte[] hash = new byte[HASH_LENGTH*nRounds];

        for(int i = 0; i < nRounds; i++) {
            md.reset();
            for(int j = 0; j < msg.length; j++)
                md.update(msg[j].toByteArray());  // hash all the messages

            md.update((byte)i);  // Also include the current index
            md.digest(hash, i*HASH_LENGTH, HASH_LENGTH);
        }

        // Now we got all the bits. Make a BigInteger out of it:
        return new BigInteger(hash).mod(q);
    }


    /**
     * Converts a short into its little-endian byte string representation.
     *
     * @param	array	the array in which to store the byte string.
     * @param	offset	the offset in the array where the string will start.
     * @param	value	the value to convert.
     */
    public static void bytesFromShort(byte[] array, int offset, short value) {
        array[offset+0] = (byte) ((value>>0)&0xFF);
        array[offset+1] = (byte) ((value>>8)&0xFF);
    }

    /**
     * Converts an int into its little-endian byte string representation.
     *
     * @param	array	the array in which to store the byte string.
     * @param	offset	the offset in the array where the string will start.
     * @param	value	the value to convert.
     */
    public static void bytesFromInt(byte[] array, int offset, int value) {
        array[offset+0] = (byte) ((value>>0) &0xFF);
        array[offset+1] = (byte) ((value>>8) &0xFF);
        array[offset+2] = (byte) ((value>>16)&0xFF);
        array[offset+3] = (byte) ((value>>24)&0xFF);
    }

    /**
     * Converts an int into its little-endian byte string representation, and
     * return an array containing it.
     *
     * @param	value	the value to convert.
     * @return	an array containing the byte string.
     */
    public static byte[] bytesFromInt(int value) {
        byte[] array = new byte[4];
        bytesFromInt(array, 0, value);
        return array;
    }

    /**
     * Converts an int into a little-endian byte string representation of the
     * specified length.
     *
     * @param	array	the array in which to store the byte string.
     * @param	offset	the offset in the array where the string will start.
     * @param	length	the number of bytes to store (must be 1, 2, or 4).
     * @param	value	the value to convert.
     */
    public static void bytesFromInt(byte[] array, int offset,
                                    int length, int value) {
        assert(length==1 || length==2 || length==4);

        switch (length) {
            case 1:
                array[offset] = (byte) value;
                break;
            case 2:
                bytesFromShort(array, offset, (short) value);
                break;
            case 4:
                bytesFromInt(array, offset, value);
                break;
        }
    }


    /**
     * Converts a long into its little-endian byte string representation.
     *
     * @param	array	the array in which to store the byte string.
     * @param	offset	the offset in the array where the string will start.
     * @param	value	the value to convert.
     */
    public static void bytesFromLong(byte[] array, int offset, long value) {
        array[offset+0] = (byte) ((value>>0) &0xFF);
        array[offset+1] = (byte) ((value>>8) &0xFF);
        array[offset+2] = (byte) ((value>>16)&0xFF);
        array[offset+3] = (byte) ((value>>24)&0xFF);
        array[offset+4] = (byte) ((value>>32)&0xFF);
        array[offset+5] = (byte) ((value>>40)&0xFF);
        array[offset+6] = (byte) ((value>>48)&0xFF);
        array[offset+7] = (byte) ((value>>56)&0xFF);
    }


    /**
     * Converts to a short from its little-endian byte string representation.
     *
     * @param	array	the array containing the byte string.
     * @param	offset	the offset of the byte string in the array.
     * @return	the corresponding short value.
     */
    public static short bytesToShort(byte[] array, int offset) {
        return (short) ((((short) array[offset+0] & 0xFF) << 0) |
                (((short) array[offset+1] & 0xFF) << 8));
    }

    /**
     * Converts to an unsigned short from its little-endian byte string
     * representation.
     *
     * @param	array	the array containing the byte string.
     * @param	offset	the offset of the byte string in the array.
     * @return	the corresponding short value.
     */
    public static int bytesToUnsignedShort(byte[] array, int offset) {
        return (((int) bytesToShort(array, offset)) & 0xFFFF);
    }

    /**
     * Converts to an int from its little-endian byte string representation.
     *
     * @param	array	the array containing the byte string.
     * @param	offset	the offset of the byte string in the array.
     * @return	the corresponding int value.
     */
    public static int bytesToInt(byte[] array, int offset) {
        return (int) ((((int) array[offset+0] & 0xFF) << 0)  |
                (((int) array[offset+1] & 0xFF) << 8)  |
                (((int) array[offset+2] & 0xFF) << 16) |
                (((int) array[offset+3] & 0xFF) << 24));
    }

    /**
     * Converts to an int from a little-endian byte string representation of the
     * specified length.
     *
     * @param	array	the array containing the byte string.
     * @param	offset	the offset of the byte string in the array.
     * @param	length	the length of the byte string.
     * @return	the corresponding value.
     */
    public static int bytesToInt(byte[] array, int offset, int length) {
        assert(length==1 || length==2 || length==4);

        switch (length) {
            case 1:
                return array[offset];
            case 2:
                return bytesToShort(array, offset);
            case 4:
                return bytesToInt(array, offset);
            default:
                return -1;
        }
    }

    /**
     * Converts to a string from a possibly null-terminated array of bytes.
     *
     * @param	array	the array containing the byte string.
     * @param	offset	the offset of the byte string in the array.
     * @param	length	the maximum length of the byte string.
     * @return	a string containing the specified bytes, up to and not
     *		    including the null-terminator (if present).
     */
    public static String bytesToString(byte[] array, int offset, int length) {
        int i;
        for (i=0; i<length; i++) {
            if (array[offset+i] == 0)
                break;
        }

        return new String(array, offset, i);
    }

    /**
     * Masks out and shifts a bit substring.
     *
     * @param	bits	the bit string.
     * @param	lowest	the first bit of the substring within the string.
     * @param	size	the number of bits in the substring.
     * @return	the substring.
     */
    public static int extract(int bits, int lowest, int size) {
        if (size == 32)
            return (bits >> lowest);
        else
            return ((bits >> lowest) & ((1<<size)-1));
    }

    /**
     * Masks out and shifts a bit substring.
     *
     * @param	bits	the bit string.
     * @param	lowest	the first bit of the substring within the string.
     * @param	size	the number of bits in the substring.
     * @return	the substring.
     */
    public static long extract(long bits, int lowest, int size) {
        if (size == 64)
            return (bits >> lowest);
        else
            return ((bits >> lowest) & ((1L<<size)-1));
    }

    /**
     * Masks out and shifts a bit substring; then sign extend the substring.
     *
     * @param	bits	the bit string.
     * @param	lowest	the first bit of the substring within the string.
     * @param	size	the number of bits in the substring.
     * @return	the substring, sign-extended.
     */
    public static int extend(int bits, int lowest, int size) {
        int extra = 32 - (lowest+size);
        return ((extract(bits, lowest, size) << extra) >> extra);
    }

    /**
     * Tests if a bit is set in a bit string.
     *
     * @param	flag	the flag to test.
     * @param	bits	the bit string.
     * @return	<tt>true</tt> if <tt>(bits & flag)</tt> is non-zero.
     */
    public static boolean test(long flag, long bits) {
        return ((bits & flag) != 0);
    }

    /**
     * Creates a padded upper-case string representation of the integer
     * argument in base 16.
     *
     * @param	i	an integer.
     * @return	a padded upper-case string representation in base 16.
     */
    public static String toHexString(int i) {
        return toHexString(i, 8);
    }

    /**
     * Creates a padded upper-case string representation of the integer
     * argument in base 16, padding to at most the specified number of digits.
     *
     * @param	i	an integer.
     * @param	pad	the minimum number of hex digits to pad to.
     * @return	a padded upper-case string representation in base 16.
     */
    public static String toHexString(int i, int pad) {
        String result = Integer.toHexString(i).toUpperCase();
        while (result.length() < pad)
            result = "0" + result;
        return result;
    }

    /**
     * Divides two non-negative integers, round the quotient up to the nearest
     * integer, and return it.
     *
     * @param	a	the numerator.
     * @param	b	the denominator.
     * @return	<tt>ceiling(a / b)</tt>.
     */
    public static int divRoundUp(int a, int b) {
        assert(a >= 0 && b > 0);

        return ((a + (b-1)) / b);
    }

    /**
     * Computes the inner product of two long arraies.
     *
     * @param	v1	one vector
     * @param	v2	another vector
     * @return	inner product of <code>v1</code> and <code>v2</code>
     * @throws  IllegalArgumentException if the dimesionalities of the two
     *          vectors do not match.
     */

    public static long innerProduct(long[] v1, long[] v2) {
        if(v1.length != v2.length)
            throw new IllegalArgumentException("dimesionalities do not match!");
        long s = 0;
        for(int i = 0; i < v1.length; i++)
            s += v1[i]*v2[i];

        return s;
    }

    /**
     * Computes the inner product of one integer array and one long array.
     *
     * @param	v1	the integer vector
     * @param	v2	the long vector
     * @return	inner product of <code>v1</code> and <code>v2</code>
     * @throws  RuntimeException if the dimesionalities of the two vectors do
     *          not match.
     */

    public static long innerProduct(int[] v1, long[] v2) {
        if(v1.length != v2.length)
            throw new RuntimeException("dimesionalities do not match!");
        long s = 0;
        for(int i = 0; i < v1.length; i++)
            s += v1[i]*v2[i];

        return s;
    }


    /**
     * Computes the inner product of two doulbe arraies
     *
     * @param	v1	one double vector
     * @param	v2	the other double vector
     * @return	inner product of <code>v1</code> and <code>v2</code>
     * @throws  RuntimeException if the dimesionalities of the two vectors do
     *          not match.
     */
    public static double innerProduct(double[] v1, double[] v2) {
        if(v1.length != v2.length)
            throw new RuntimeException("dimesionalities do not match!");
        double s = 0;
        for(int i = 0; i < v1.length; i++)
            s += v1[i]*v2[i];

        return s;
    }


    /**
     * A java and simplified version of daxpy, constant times a vector plus a
     * vector. Unlike its BLAS counterpart, it does NOT use unrolled loop. This
     * function is for verifying the computation. NO optimization is done.
     *
     *
     * This function does
     *
     *     y = a*x + y
     *
     * where a is a scaler and x, y are vectors.
     *
     */
    public static void laxpy(long a, long[] x, long[] y) {
        for(int i = 0; i < x.length; i++) {
            y[i] = a*x[i]+y[i];
        }
    }

    public static void laxpy(double a, double[] x, double[] y) {
        for(int i = 0; i < x.length; i++) {
            y[i] = a*x[i]+y[i];
        }
    }


    /**
     * Returns a number whose value is between [-m/2, m/2) and differs
     * from data by a multiple of m.
     *
     * @param	data	a long integer.
     * @param   m       the modulus.
     * @return	a number between [-m/2, m/2) that differs from data by a multiple of m.
     */
    public static long mod(long data, long m) {
        long r = data%m;
        if(r < 0)  r += m;
        if(r >= Math.floor((double)m/2.))
            r -= m;
        return r;
    }


    /**
     * Converts the integers in the given array <code>data</code> into double
     * precision floating point numbers. The integers should be between
     *
     *     [-floor(F/2), floor(F/2)] if F is odd
     *     [-floor(F/2), floor(F/2)-1] if F is even
     *
     * and the real numbers will be between [-R, R].
     * <p>
     * This provides a mapping between the finite field [-F/2, F/2] where our
     * P4P computations are performed and the field of real numbers where many
     * applications run.
     *
     * @param	data	the array of longs to be converted
     * @param   offset  starting position in the array
     * @param   len     then number of elements to be cpnverted.
     * @param   F       the size of the finite field where private P4P
     *                  computation is carried out
     * @param   R       the maximum value of the floating point number that
     *                  the system supports.
     * @return	an array of doubles between [-R, R].
     */
    public static double[] itor(long[] data, int offset, int len, long F,
                                double R) {
        double [] v = new double[len];

        double alpha = 2.d*R/F;
        for(int i = 0; i < len; i++)
            v[i] = (double)data[offset+i]*alpha;

        return v;
    }


    /**
     * Converts the integers in the given array <code>data</code> into double
     * precision floating point numbers. The integers should be between
     *
     *     [-floor(F/2), floor(F/2)] if F is odd
     *     [-floor(F/2), floor(F/2)-1] if F is even
     *
     * and the real numbers will be between [-R, R].
     * <p>
     * This provides a mapping between the finite field [-F/2, F/2] where our
     * P4P computations are performed and the field of real numbers where many
     * applications run.
     *
     * @param	data	the array of longs to be converted
     * @param   F       the size of the finite field where private P4P
     *                  computation is carried out
     * @param   R       the maximum value of the floating point number that
     *                  the system supports.
     * @return	an array of doubles between [-R, R].
     */
    public static double[] itor(long[] data, long F, double R) {
        return itor(data, 0, data.length, F, R);
        /*
          double [] v = new double[data.length];

          double alpha = 2.d*R/F;
          for(int i = 0; i < data.length; i++)
          v[i] = (double)data[i]*alpha;

          return v;
        */
    }


    /**
     * Converts the integers in the given array <code>data</code> into double
     * precision floating point numbers. The integers should be between
     *
     *     [-floor(F/2), floor(F/2)] if F is odd
     *     [-floor(F/2), floor(F/2)-1] if F is even
     *
     * and the real numbers will be between [-R, R].
     * <p>
     * This provides a mapping between the finite field [-F/2, F/2] where our
     * P4P computations are performed and the field of real numbers where many
     * applications run.
     *
     * @param	data	the array of longs to be converted
     * @param   F       the size of the finite field where private P4P
     *                  computation is carried out
     * @param   R       the maximum value of the floating point number that
     *                  the system supports.
     * @return	an array of doubles between [-R, R].
     */
    public static double[][] itor(long[][] data, long F, double R) {
        double [][] v = new double[data.length][data[0].length];

        for(int i = 0; i < data.length; i++)
            v[i] = Util.itor(data[i], F, R);

        return v;
    }


    /**
     * Converts the double precision floating point numbers in the given array
     * <code>data</code> into integers field. The integers should be between
     *
     *     [-floor(F/2), floor(F/2)] if F is odd
     *     [-floor(F/2), floor(F/2)-1] if F is even
     *
     * and the real numbers will be between [-R, R].
     * <p>
     * This provides a mapping between the finite field [-F/2, F/2] where our
     * P4P computations are performed and the field of real numbers where many
     * applications run.
     *
     * @param	data	the array of doubles to be converted
     * @param   offset  starting position in the array
     * @param   len     then number of elements to be cpnverted.
     * @param   F       the size of the finite field where private P4P
     *                  computation is carried out
     * @param   R       the maximum value of the floating point number that
     *                  the system supports.
     * @return	an array of integers between [-F/2, F/2).
     */
    public static long[] rtoi(double[] data, int offset, int len, long F,
                              double R) {
        long [] v = new long[len];

        double alpha = 2.d*R/F;
        for(int i = 0; i < len; i++)
            v[i] = Math.round(data[i+offset]/alpha);

        return v;
    }

    /**
     * Converts the double precision floating point numbers in the given array
     * <code>data</code> into integers field. The integers should be between
     *
     *     [-floor(F/2), floor(F/2)] if F is odd
     *     [-floor(F/2), floor(F/2)-1] if F is even
     *
     * and the real numbers will be between [-R, R].
     * <p>
     * This provides a mapping between the finite field [-F/2, F/2] where our
     * P4P computations are performed and the field of real numbers where many
     * applications run.
     *
     * @param	data	the array of doubles to be converted
     * @param   F       the size of the finite field where private P4P
     *                  computation is carried out
     * @param   R       the maximum value of the floating point number that
     *                  the system supports.
     * @return	an array of integers between [-F/2, F/2).
     */
    public static long[] rtoi(double[] data, long F, double R) {
        return rtoi(data, 0, data.length, F, R);
        /*
          long [] v = new long[data.length];

          double alpha = 2.d*R/F;
          for(int i = 0; i < data.length; i++)
          v[i] = Math.round(data[i]/alpha);

          return v;
        */
    }

    /**
     * Converts the double precision floating point numbers in the given array
     * <code>data</code> into integers field. The integers should be between
     *
     *     [-floor(F/2), floor(F/2)] if F is odd
     *     [-floor(F/2), floor(F/2)-1] if F is even
     *
     * and the real numbers will be between [-R, R].
     * <p>
     * This provides a mapping between the finite field [-F/2, F/2] where our
     * P4P computations are performed and the field of real numbers where many
     * applications run.
     *
     * @param	data	the array of doubles to be converted
     * @param   F       the size of the finite field where private P4P
     *                  computation is carried out
     * @param   R       the maximum value of the floating point number that
     *                  the system supports.
     * @return	an array of integers of length <code>len</code> between [-F/2, F/2).
     */
    public static long[][] rtoi(double[][] data, long F, double R) {
        long [][] v = new long[data.length][data[0].length];

        for(int i = 0; i < data.length; i++)
            v[i] = Util.rtoi(data[i], F, R);

        return v;
    }

    /**
     * Returns the minimum value in the given double array.
     *
     * @param	data	the array of doubles
     * @return	the minimum value in <code>data</code>
     */
    public static double min(double[] data) {
        double min = Double.MAX_VALUE;
        for(int i = 0; i < data.length; i++)
            min = min > data[i] ? data[i] : min;
        return min;
    }

    /**
     * Returns the maximum value in the given double array.
     *
     * @param	data	the array of doubles
     * @return	the maximum value in <code>data</code>
     */
    public static double max(double[] data) {
        double max = Double.MIN_VALUE;
        for(int i = 0; i < data.length; i++)
            max = max < data[i] ? data[i] : max;
        return max;
    }

    /**
     * Returns the maximum value in the given double array.
     *
     * @param	data	the array of doubles
     * @return	the maximum value in <code>data</code>
     */
    public static double max(double[][] data) {
        double max = Double.MIN_VALUE;
        for(int i = 0; i < data.length; i++) {
            double mx = Util.max(data[i]);
            max = max < mx ? mx : max;
        }
        return max;
    }


    /**
     * Returns the maximum absolute value in the given double array.
     *
     * @param	data	the array of doubles
     * @return	the maximum absolute value in <code>data</code>
     */
    public static double maxAbs(double[] data) {
        return maxAbs(data, 0, data.length);
        /*
          double max = 0.;
          for(int i = 0; i < data.length; i++) {
          double mx = Math.abs(data[i]);
          max = max < mx ? mx : max;
          }
          return max;
        */
    }


    /**
     * Returns the maximum absolute value in the given long array.
     *
     * @param	data	the array of longs
     * @return	the maximum absolute value in <code>data</code>
     */
    public static long maxAbs(long[] data) {
        //	return maxAbs(data, 0, data.length);

        long max = 0;
        for(int i = 0; i < data.length; i++) {
            long mx = (long)Math.abs(data[i]);
            max = max < mx ? mx : max;
        }
        return max;

    }


    /**
     * Returns the maximum absolute value in the given long array.
     *
     * @param	data	the array of longs
     * @return	the maximum absolute value in <code>data</code>
     */
    public static long maxAbs(long[] data, int offset, int len) {
        long max = 0;
        for(int i = 0; i < len; i++) {
            long mx = (long)Math.abs(data[offset+i]);
            max = max < mx ? mx : max;
        }
        return max;
    }


    public static double maxAbs(double[] data, int offset, int len) {
        double max = 0.;
        for(int i = 0; i < len; i++) {
            double mx = Math.abs(data[offset+i]);
            max = max < mx ? mx : max;
        }
        return max;
    }

    /**
     * Returns the maximum absolute value in the given double array.
     *
     * @param	data	the array of doubles
     * @return	the maximum absolute value in <code>data</code>
     */
    public static double maxAbs(double[][] data) {
        double max = 0.;
        for(int i = 0; i < data.length; i++) {
            double mx = Util.maxAbs(data[i]);
            max = max < mx ? mx : max;
        }
        return max;
    }


    /**
     * Returns the maximum value in the given long array.
     *
     * @param	data	the array of longs
     * @return	the maximum value in <code>data</code>
     */
    public static long max(long[] data) {
        long max = Long.MIN_VALUE;
        for(int i = 0; i < data.length; i++)
            max = max < data[i] ? data[i] : max;
        return max;
    }

    /**
     * Generates a random vector in Z_F with approximately the given L2-norm.
     * The algorithm is as follows: first a random m-dimensional vector over
     * Z_F is generated by selecting each elements randomly from Z_F. The
     * vector is then scaled to the desired length, rounding each element to
     * the nearest long. Note that Z_F is defined as
     *
     *     [-floor(F/2), floor(F/2)] if F is odd
     *     [-floor(F/2), floor(F/2)-1] if F is even
     *
     *
     * NOTE:
     *         F is to big. A random vector generated this way is so big
     *         that the scaling factor is essentially 0, resulting in a zero
     *         vector. Instead, we restrict each element between [-L, L]. We
     *         are choosing from a set with (2L)^m elements, instead of F^m,
     *         where L is chosen to be 1000. This function is only for test.
     *         Should be OK.
     * @param m    the dimensionality of the vector
     * @param F    the order of the group Z_F
     * @param l2   the desired l2-norm of the vector. If it is 0, then a random
     *             vector in (Z_F)^m is generated.
     * @return	   a random vector over Z_F L2-norm equal <code>l2</code>
     */

    public static long[] randVector(int m, long F, double l2) {
        long[] data = new long[m];

        BigInteger bigF = null;
        if(l2 <=0) bigF = new BigInteger(Long.toString(F));
        double myL2 = 0.;
        int L = 10000;
        for(int i = 0; i < m; i++) {
            if(l2 > 0) {
                /**
                 * NOTE: F is to big. A random vector generated this way is so
                 * big that the scaling factor is essentially 0, resulting in a
                 * zero vector. Instead, we restrict each element between
                 * [-L, L]. We are choosing from a set with (2L)^m elements,
                 * instead of F^m. This function is only for testing. Should be
                 * OK.
                 */
                data[i] = rand.nextInt(2*L+1)-L;
                myL2 += (double)((double)data[i]*(double)data[i]);
                /**
                 * Let dmax = Double.MAX_VALUE = 1.7976931348623157E308 and
                 * lmax = Long.MAX_VALUE = 9223372036854775807L. The maximum
                 * L2-norm of data can be m*(lmax*lmax) = 8.5071e+037. Using a
                 * double to hold the value, m can be as large as 2.1132e+270.
                 * More than enough for our purpose and no overflow would
                 * happen.
                 */
            }
            else {
                data[i] = randomBigInteger(bigF).longValue();
                // A random long in [0, F-1]
                data[i] -= Math.floor((double)F/2.);
                // Shift to Z_F
            }
        }
        if(l2 > 0) {
            myL2 = Math.sqrt(myL2);
            double scale = l2/myL2;
            for(int i = 0; i < m; i++) {
                if(data[i] > 0) data[i] = (long)(((double)data[i]+0.5)*scale);
                else data[i] = (long)(((double)data[i]-0.5)*scale);
                // Round to the closest long
            }
        }
        return data;
    }


    /**
     * Adds two vectors in the field Z_F.
     * @param v1   one vector
     * @param v2   the other vector
     * @param s    the vector where the resulting <code>v1+v2</code> should
     *             be stored.
     * @param F    the order of the group Z_F
     * @throws     IllegalArgumentException if the dimesionalities of the
     *             vectors do not match.
     */
    public static void vectorAdd(long[] v1, long[] v2, long[] s, long F) {
        int m = s.length;
        if(v1.length != m || v2.length != m)
            throw new IllegalArgumentException("dimesionalities do not match!");

        for(int j = 0; j < m; j++) {
            // Assuming F is at least a few bits less than a long, a single
            // addition won't cause overflow. So we can do mod afterwards.
            // But we do need to do mod once for a few additions since the
            // shares can be any number in Z_F.
            s[j] = mod(v1[j] + v2[j], F);
        }
    }

    public static void vectorThreeAdd(long[] v1, long[] v2, long[] v3, long[] s, long F) {
        int m = s.length;
        if(v1.length != m || v2.length != m || v3.length !=m)
            throw new IllegalArgumentException("dimesionalities do not match!");

        for(int j = 0; j < m; j++) {
            // Assuming F is at least a few bits less than a long, a single
            // addition won't cause overflow. So we can do mod afterwards.
            // But we do need to do mod once for a few additions since the
            // shares can be any number in Z_F.
            s[j] = mod(v1[j] + v2[j] + v3[j], F);
        }
    }
}
