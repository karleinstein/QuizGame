package com.example.karleinstein.iqtest;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.karleinstein.iqtest.beginner.Level1;
import com.example.karleinstein.iqtest.beginner.Level2;
import com.example.karleinstein.iqtest.beginner.Level3;
import com.example.karleinstein.iqtest.beginner.Level4;
import com.example.karleinstein.iqtest.beginner.Level5;
import com.example.karleinstein.iqtest.beginner.Level6;
import com.example.karleinstein.iqtest.beginner.Level7;
import com.example.karleinstein.iqtest.beginner.Level8;
import com.example.karleinstein.iqtest.beginner.Level9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class BlankFragment2 extends Fragment {
    public BlankFragment2() {
        // Required empty public constructor
    }
    TextView tvBeginer;
    int why;
    InputStreamReader inputStreamReader;
    FileInputStream fileInputStream;
    BufferedReader bufferedReader;
    StringBuffer stringBuffer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_blank_fragment2,container,false);
        tvBeginer=view.findViewById(R.id.tvBeginner);
        ImageButton btn1=view.findViewById(R.id.lv1);
        ImageButton btn2=view.findViewById(R.id.lv2);
        ImageButton btn3=view.findViewById(R.id.lv3);
        ImageButton btn4=view.findViewById(R.id.lv4);
        ImageButton btn5=view.findViewById(R.id.lv5);
        ImageButton btn6=view.findViewById(R.id.lv6);
        ImageButton btn7=view.findViewById(R.id.lv7);
        ImageButton btn8=view.findViewById(R.id.lv8);
        ImageButton btn9=view.findViewById(R.id.lv9);
        TextView tvIntro=view.findViewById(R.id.tvIntro);

        Typeface typefacez = Typeface.createFromAsset(getActivity().getAssets(), "fonts/song.ttf");
        tvBeginer.setTypeface(typefacez);
        //Intent intent=getActivity().getIntent();
        //double trashz=intent.getDoubleExtra("Karl",0);
        //tvYourIq.setText(trashz+"");
        score();
        String dulieu;
        try {
            fileInputStream=getActivity().openFileInput("levels.txt");
            inputStreamReader=new InputStreamReader(fileInputStream);
            bufferedReader=new BufferedReader(inputStreamReader);
            stringBuffer=new StringBuffer();
            while ((dulieu=bufferedReader.readLine())!=null)
            {
                stringBuffer.append(dulieu+"");
            }
            why=Integer.valueOf(String.valueOf(stringBuffer));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (getArguments().getInt("key_color"))
        {

            case 1:
                tvBeginer.setText("GENIUS");

                break;
            case 2:
                tvBeginer.setText("DOG BRAIN");
                tvIntro.setText("1% of people can complete");
                break;
                default:
                    tvBeginer.setText("BEGINNER");
                    tvIntro.setText("90% of people can complete");
                    btn1.setImageResource(R.drawable.lv1img);
                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent=new Intent(getActivity(),Level1.class);
                            startActivity(intent);
                        }
                    });
                    switch (why)
                    {
                        case 1:
                        btn2.setImageResource(R.drawable.lv2img);
                        btn2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent=new Intent(getActivity(),Level2.class);
                                startActivity(intent);
                            }
                        });
                        break;
                        case 2:
                            btn2.setImageResource(R.drawable.lv2img);
                            btn2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level2.class);
                                    startActivity(intent);
                                }
                            });
                            btn3.setImageResource(R.drawable.level3);
                            btn3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level3.class);
                                    startActivity(intent);
                                }
                            });
                            break;
                        case 3:
                            btn2.setImageResource(R.drawable.lv2img);
                            btn2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level2.class);
                                    startActivity(intent);
                                }
                            });
                            btn3.setImageResource(R.drawable.level3);
                            btn3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level3.class);
                                    startActivity(intent);
                                }
                            });
                            btn4.setImageResource(R.drawable.level4);
                            btn4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level4.class);
                                    startActivity(intent);
                                }
                            });
                            break;
                        case 4:
                            btn2.setImageResource(R.drawable.lv2img);
                            btn2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level2.class);
                                    startActivity(intent);
                                }
                            });
                            btn3.setImageResource(R.drawable.level3);
                            btn3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level3.class);
                                    startActivity(intent);
                                }
                            });
                            btn4.setImageResource(R.drawable.level4);
                            btn4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level4.class);
                                    startActivity(intent);
                                }
                            });
                            btn5.setImageResource(R.drawable.level5);
                            btn5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level5.class);
                                    startActivity(intent);
                                }
                            });
                            break;
                        case 5:
                            btn2.setImageResource(R.drawable.lv2img);
                            btn2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level2.class);
                                    startActivity(intent);
                                }
                            });
                            btn3.setImageResource(R.drawable.level3);
                            btn3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level3.class);
                                    startActivity(intent);
                                }
                            });
                            btn4.setImageResource(R.drawable.level4);
                            btn4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level4.class);
                                    startActivity(intent);
                                }
                            });
                            btn5.setImageResource(R.drawable.level5);
                            btn5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level5.class);
                                    startActivity(intent);
                                }
                            });
                            btn6.setImageResource(R.drawable.level6);
                            btn6.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level6.class);
                                    startActivity(intent);
                                }
                            });
                            break;
                        case 6:
                            btn2.setImageResource(R.drawable.lv2img);
                            btn2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level2.class);
                                    startActivity(intent);
                                }
                            });
                            btn3.setImageResource(R.drawable.level3);
                            btn3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level3.class);
                                    startActivity(intent);
                                }
                            });
                            btn4.setImageResource(R.drawable.level4);
                            btn4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level4.class);
                                    startActivity(intent);
                                }
                            });
                            btn5.setImageResource(R.drawable.level5);
                            btn5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level5.class);
                                    startActivity(intent);
                                }
                            });
                            btn6.setImageResource(R.drawable.level6);
                            btn6.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level6.class);
                                    startActivity(intent);
                                }
                            });
                            btn7.setImageResource(R.drawable.level7);
                            btn7.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level7.class);
                                    startActivity(intent);
                                }
                            });
                            break;
                        case 7:
                            btn2.setImageResource(R.drawable.lv2img);
                            btn2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level2.class);
                                    startActivity(intent);
                                }
                            });
                            btn3.setImageResource(R.drawable.level3);
                            btn3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level3.class);
                                    startActivity(intent);
                                }
                            });
                            btn4.setImageResource(R.drawable.level4);
                            btn4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level4.class);
                                    startActivity(intent);
                                }
                            });
                            btn5.setImageResource(R.drawable.level5);
                            btn5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level5.class);
                                    startActivity(intent);
                                }
                            });
                            btn6.setImageResource(R.drawable.level6);
                            btn6.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level6.class);
                                    startActivity(intent);
                                }
                            });
                            btn7.setImageResource(R.drawable.level7);
                            btn7.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level7.class);
                                    startActivity(intent);
                                }
                            });
                            btn8.setImageResource(R.drawable.level8);
                            btn8.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level8.class);
                                    startActivity(intent);
                                }
                            });
                            break;
                        case 8:
                            btn2.setImageResource(R.drawable.lv2img);
                            btn2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level2.class);
                                    startActivity(intent);
                                }
                            });
                            btn3.setImageResource(R.drawable.level3);
                            btn3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level3.class);
                                    startActivity(intent);
                                }
                            });
                            btn4.setImageResource(R.drawable.level4);
                            btn4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level4.class);
                                    startActivity(intent);
                                }
                            });
                            btn5.setImageResource(R.drawable.level5);
                            btn5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level5.class);
                                    startActivity(intent);
                                }
                            });
                            btn6.setImageResource(R.drawable.level6);
                            btn6.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level6.class);
                                    startActivity(intent);
                                }
                            });
                            btn7.setImageResource(R.drawable.level7);
                            btn7.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level7.class);
                                    startActivity(intent);
                                }
                            });
                            btn8.setImageResource(R.drawable.level8);
                            btn8.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level8.class);
                                    startActivity(intent);
                                }
                            });
                            btn9.setImageResource(R.drawable.level9);
                            btn9.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level9.class);
                                    startActivity(intent);
                                }
                            });
                            break;
                        case 9:
                            btn2.setImageResource(R.drawable.lv2img);
                            btn2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level2.class);
                                    startActivity(intent);
                                }
                            });
                            btn3.setImageResource(R.drawable.level3);
                            btn3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level3.class);
                                    startActivity(intent);
                                }
                            });
                            btn4.setImageResource(R.drawable.level4);
                            btn4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level4.class);
                                    startActivity(intent);
                                }
                            });
                            btn5.setImageResource(R.drawable.level5);
                            btn5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level5.class);
                                    startActivity(intent);
                                }
                            });
                            btn6.setImageResource(R.drawable.level6);
                            btn6.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level6.class);
                                    startActivity(intent);
                                }
                            });
                            btn7.setImageResource(R.drawable.level7);
                            btn7.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level7.class);
                                    startActivity(intent);
                                }
                            });
                            btn8.setImageResource(R.drawable.level8);
                            btn8.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level8.class);
                                    startActivity(intent);
                                }
                            });
                            btn9.setImageResource(R.drawable.level9);
                            btn9.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(getActivity(),Level9.class);
                                    startActivity(intent);
                                }
                            });
                            break;
                    }
                    break;
        }

        // Inflate the layout for this fragment

        return view;
    }
    public void score()
    {
        String dulieu;
        try {
            FileInputStream fileInputStream=getActivity().openFileInput("Highscore.txt");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer=new StringBuffer();
            while ((dulieu=bufferedReader.readLine())!=null)
            {
                stringBuffer.append(dulieu+"");
            }
            //TextView tvYourIQ=v.findViewById(R.id.tvYourIq);
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
