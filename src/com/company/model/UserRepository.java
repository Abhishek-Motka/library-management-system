package com.company.model;

import com.company.exceptions.MemberDoesNotExistException;

import java.util.HashMap;
import java.util.Map;

public class UserRepository
{
    private static UserRepository userRepository;
    private Map<String, Member> members;

    private UserRepository()
    {
        this.members = new HashMap<>();
    }

    public static UserRepository getInstance() {
        if (userRepository != null) return userRepository;
        synchronized (UserRepository.class) {
            if (userRepository == null) {
                userRepository = new UserRepository();
            }
        }
        return userRepository;
    }

    public void addMember(Member member) {
        members.put(member.getId(), member);
    }

    public Member removeMember(String memberId) {
        if (!members.containsKey(memberId)) throw new MemberDoesNotExistException();
        return members.remove(memberId);
    }

    public Member getMember(String memberId) {
        if (!members.containsKey(memberId)) throw new MemberDoesNotExistException();
        return members.get(memberId);
    }
}
