package com.example.lld_demo.repositories;

import com.example.lld_demo.domain.model.GroupMember;

public interface GroupMemberRepository extends JpaRepository <GroupMember, UUID> {

    List<GroupMember> findByGroupId(UUID groupId);

    boolean existsByGroupIdANd
}
