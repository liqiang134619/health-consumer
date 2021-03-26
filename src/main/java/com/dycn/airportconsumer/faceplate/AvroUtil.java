package com.dycn.airportconsumer.faceplate;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.*;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liq
 * @date 2021/1/23
 */
public class AvroUtil {





    /**
     * 二进制解码成GenericRecord
     *
     * @param avroSchema  园区传来的schema
     * @param schema      门禁自己用的schema
     * @param recordBytes 二进制数据
     * @return List<GenericRecord>
     * @throws IOException 异常
     */
    public static List<GenericRecord> decodeCompatibility(String avroSchema, Schema schema, byte[] recordBytes) throws IOException {
        if (avroSchema == null) {
            return decode(schema, recordBytes);
        } else {
            Schema writeSchema = Schema.parse(avroSchema);
            DatumReader<GenericRecord> datumReader = new SpecificDatumReader<GenericRecord>(writeSchema, schema);

            BinaryDecoder decoder = DecoderFactory.get().binaryDecoder(recordBytes, null);
            List<GenericRecord> records = new ArrayList<GenericRecord>();
            while (true) {
                try {
                    GenericRecord record = datumReader.read(null, decoder);
                    records.add(record);
                } catch (EOFException e) {
                    break;
                }
            }
            return records;
        }
    }




    /**
     * 二进制解码成Avro对象
     *
     * @param schema      Avro的schema
     * @param recordBytes 二进制数据
     * @return Avro对象
     * @throws IOException 异常
     */
    public static List<GenericRecord> decode(Schema schema, byte[] recordBytes) throws IOException {
        try (ByteArrayInputStream stream = new ByteArrayInputStream(recordBytes)) {
            stream.reset();
            BinaryDecoder binaryDecoder = new DecoderFactory().binaryDecoder(stream, null);
            List<GenericRecord> records = new ArrayList<>();
            DatumReader<GenericRecord> datumReader = new SpecificDatumReader<>(schema);
            while (true) {
                try {
                    GenericRecord record = datumReader.read(null, binaryDecoder);
                    records.add(record);
                } catch (EOFException e) {
                    break;
                }
            }
            return records;
        }
    }


    /**
     * Avro对象转成二进制,用于HTTP传输
     *
     * @param schema  Avro的schema
     * @param records Avro对象
     * @return 二进制数据
     * @throws IOException 异常
     */
    public static ByteBuf encode(Schema schema, List<GenericRecord> records) throws IOException {
        final ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(1024);
        SpecificDatumWriter<GenericRecord>
                datumWriter =
                new SpecificDatumWriter<>(schema);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.reset();
        BinaryEncoder binaryEncoder = new EncoderFactory().binaryEncoder(byteArrayOutputStream, null);
        for (GenericRecord segment : records) {
            datumWriter.write(segment, binaryEncoder);
        }
        binaryEncoder.flush();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        buffer.writeBytes(bytes);
        return buffer;
    }
}
