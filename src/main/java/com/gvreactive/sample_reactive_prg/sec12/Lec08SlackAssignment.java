package com.gvreactive.sample_reactive_prg.sec12;

import com.gvreactive.sample_reactive_prg.common.Util;
import com.gvreactive.sample_reactive_prg.sec12.assignment.SlackRoom;
import com.gvreactive.sample_reactive_prg.sec12.assignment.SlackMember;

public class Lec08SlackAssignment {
    public static void main(String[] args) {
        var room = new SlackRoom("reactor");
        var sam=new SlackMember("sam");
        var jake=new SlackMember("jake");
        var mike=new SlackMember("mike");
        //add 2 members
        room.addMember(sam);
        room.addMember(jake);
        sam.says("Hi all..");
        Util.sleepSeconds(4);
        jake.says("Hey!");
        sam.says("I am simply wanted say Hi");
        Util.sleepSeconds(4);
        room.addMember(mike);
        mike.says("Hey guys glad");
    }
}
