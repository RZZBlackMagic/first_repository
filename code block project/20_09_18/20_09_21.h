#ifndef 20_09_21_H_INCLUDED
#define 20_09_21_H_INCLUDED

struct student {
    string name;
    int score;
    int age;
};

struct teacher{
    string name;
    struct stuednt s[5];
};

void m_main(){
    struct student s1[5] = {
    {
        "������",100,18
    };{
        "����",99,19
    };
    {
        "С·",98,17
    };
    {
        "luxinjing",96,19
    };
    {
        "·�ľ�",00,1
    }
    };
    struct teacher t = {"��ͼ",s1};
}

#endif // 20_09_21_H_INCLUDED
