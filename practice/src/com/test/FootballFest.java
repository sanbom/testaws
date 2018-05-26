package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
 
/**
 * Created by mahantys on 25/12/16.
 */
 
public class FootballFest {
 
    static BufferedReader br;
    static Reader reader;
 
    public static int findPlayerAfterLastPass(int n, int startId) throws IOException {
        int curr = startId;
        int prev = -1;
        if (n == 1) {
            return startId;
        }
 
        for (int i = 0; i < n; i++) {
            // String line = br.readLine();
            int element = prev;
            char op = reader.nextChar();
            if (op == 'P') {
                element = reader.nextInt();
            }
            //System.out.println("OP: " + op + "   value: " + element);
            prev = curr;
            curr = element;
        }
 
        return curr;
    }
 
    public static int parseInt(final String s) {
        final int len = s.length();
        final char ch = s.charAt(0);
        int num = '0' - ch;
        int i = 1;
 
        while (i < len)
            num = num * 10 + '0' - s.charAt(i++);
 
        return num * -1;
    }
 
    public static void main(String[] args) throws IOException {
        reader = new Reader();
        //br = new BufferedReader(new FileReader("testdata/footballfest"));
        int c = reader.nextInt();
        //long startTime = System.currentTimeMillis();
        for (int i = 0; i < c; i++) {
            //String[] tokens = br.readLine().split(" ");
            int n = reader.nextInt();
            int startId = reader.nextInt();
            //System.out.println(" N: " + n + "  startId: " + startId);
            int result = findPlayerAfterLastPass(n, startId);
            System.out.println("Player " + result);
        }
        //long endTime = System.currentTimeMillis();
        //System.out.println("Time: " + ((double) (endTime - startTime) / 1000) + " second(s)");
    }
 
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public char nextChar() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
 
            return (char) c;
        }
 
        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}
