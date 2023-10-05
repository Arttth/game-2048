package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Field {
    int size;
    private Block[][] blocks;
    int startBlockCount = 3;

    Field(int size){
        this.size = size;
        blocks = new Block[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                blocks[i][j] = new Block(0);
            }
        }
    }

    Block[][] getField() {
        return blocks;
    }

    void setSize(int size) {
        this.size = size;
        blocks = new Block[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                blocks[i][j] = new Block(0);
            }
        }
    }


    void setBlock(int i, int j, int value) {
        blocks[i][j].setValue(value);
    }

    void initField() {
        for (int i = 0; i < startBlockCount; ++i) {
            this.setRandomBlock();
        }
    }

    boolean isFreeBlocks() {
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (blocks[i][j].getValue() == Block.emptyBlock) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean setRandomBlock() {
        if (!isFreeBlocks()) return false;
        Random random = new Random();
        ArrayList<Integer> coord = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (blocks[i][j].getValue() == Block.emptyBlock) {
                    coord.add(i);
                    coord.add(j);
                }
            }
        }
        int rand = random.nextInt(coord.size()/2);

        int i = coord.get(rand*2);
        int j = coord.get(rand*2+1);
        blocks[i][j].setValue(2);
        return true;
    }


    // size-2 - penultimate column
    void actRight() {
        for (int i = 0; i < size; i++) {
            for (int j = size-2; j >= 0; j--) {
                int curValue = blocks[i][j].getValue();
                if (curValue == Block.emptyBlock) continue;
                int blockIndex = j + 1;
                while (true) {
                    if (blockIndex == size-1 && blocks[i][blockIndex].getValue() == Block.emptyBlock) {
                        blocks[i][blockIndex].setValue(curValue);
                        blocks[i][j].setValue(Block.emptyBlock);
                        break;
                    }
                    else if (blocks[i][blockIndex].getValue() == curValue) {
                        blocks[i][blockIndex].updateValue();
                        blocks[i][j].setValue(Block.emptyBlock);
                        break;
                    }
                    else if (blocks[i][blockIndex].getValue() != Block.emptyBlock) {
                        blocks[i][blockIndex-1].setValue(curValue);
                        blocks[i][j].setValue(Block.emptyBlock);
                        break;
                    }
                    else if (blocks[i][blockIndex].getValue() == Block.emptyBlock) {
                        blockIndex++;
                    }
                }
            }
        }
    }

    void actLeft() {
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < size; j++) {
                int curValue = blocks[i][j].getValue();
                if (curValue == Block.emptyBlock) continue;
                int blockIndex = j - 1;
                while (true) {
                    if (blockIndex == 0 && blocks[i][blockIndex].getValue() == Block.emptyBlock) {
                        blocks[i][blockIndex].setValue(curValue);
                        blocks[i][j].setValue(Block.emptyBlock);
                        break;
                    }
                    else if (blocks[i][blockIndex].getValue() == curValue) {
                        blocks[i][blockIndex].updateValue();
                        blocks[i][j].setValue(Block.emptyBlock);
                        break;
                    }
                    else if (blocks[i][blockIndex].getValue() != Block.emptyBlock) {
                        blocks[i][blockIndex+1].setValue(curValue);
                        blocks[i][j].setValue(Block.emptyBlock);
                        break;
                    }
                    else if (blocks[i][blockIndex].getValue() == Block.emptyBlock) {
                        blockIndex--;
                    }
                }
            }
        }
    }

    void actUp() {
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int curValue = blocks[i][j].getValue();
                if (curValue == Block.emptyBlock) continue;
                int blockIndex = i - 1;
                while (true) {
                    if (blockIndex == 0 && blocks[blockIndex][j].getValue() == Block.emptyBlock) {
                        blocks[blockIndex][j].setValue(curValue);
                        blocks[i][j].setValue(Block.emptyBlock);
                        break;
                    }
                    else if (blocks[blockIndex][j].getValue() == curValue) {
                        blocks[blockIndex][j].updateValue();
                        blocks[i][j].setValue(Block.emptyBlock);
                        break;
                    }
                    else if (blocks[blockIndex][j].getValue() != Block.emptyBlock) {
                        blocks[blockIndex+1][j].setValue(curValue);
                        blocks[i][j].setValue(Block.emptyBlock);
                        break;
                    }
                    else if (blocks[blockIndex][j].getValue() == Block.emptyBlock) {
                        blockIndex--;
                    }
                }
            }
        }
    }

    void actDown() {
        for (int i = size-2; i >= 0; i--) {
            for (int j = 0; j < size; j++) {
                int curValue = blocks[i][j].getValue();
                if (curValue == Block.emptyBlock) continue;
                int blockIndex = i + 1;
                while (true) {
                    if (blockIndex == size-1 && blocks[blockIndex][j].getValue() == Block.emptyBlock) {
                        blocks[blockIndex][j].setValue(curValue);
                        blocks[i][j].setValue(Block.emptyBlock);
                        break;
                    }
                    else if (blocks[blockIndex][j].getValue() == curValue) {
                        blocks[blockIndex][j].updateValue();
                        blocks[i][j].setValue(Block.emptyBlock);
                        break;
                    }
                    else if (blocks[blockIndex][j].getValue() != Block.emptyBlock) {
                        blocks[blockIndex-1][j].setValue(curValue);
                        blocks[i][j].setValue(Block.emptyBlock);
                        break;
                    }
                    else  {
                        blockIndex++;
                    }
                }
            }
        }
    }
}
