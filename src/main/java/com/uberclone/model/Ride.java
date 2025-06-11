package com.uberclone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "cab_id")
    private Cab cab;

    @OneToOne
    @JoinColumn(name = "pickup_location_id", nullable = false)
    private Location pickupLocation;

    @OneToOne
    @JoinColumn(name = "dropoff_location_id", nullable = false)
    private Location dropoffLocation;

    @Column(nullable = false)
    private LocalDateTime requestTime;

    @Column
    private LocalDateTime pickupTime;

    @Column
    private LocalDateTime dropoffTime;

    @Column
    private Double distance; // in kilometers

    @Column
    private Double duration; // in minutes

    @Column
    private Double fare;

    @Column
    private String status; // REQUESTED, ACCEPTED, IN_PROGRESS, COMPLETED, CANCELLED

    @Column
    private String paymentStatus; // PENDING, COMPLETED, FAILED

    @Column
    private String rideType; // STANDARD, PREMIUM, SHARE

    @Column
    private Boolean isActive = true;
} 